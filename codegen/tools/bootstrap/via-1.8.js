const fs = require("fs");
const via = fs.readFileSync(process.argv[2], "utf8");
const snap19 = JSON.parse(fs.readFileSync(process.argv[3], "utf8"));
const CLASS = {
  ENTITY: "Entity", LIVING_ENTITY_BASE: "Living Entity", LIVING_ENTITY: "Mob", ABSTRACT_AGEABLE: "Agable Mob",
  ARMOR_STAND: "Armor Stand", PLAYER: "Player", HORSE: "Horse", BAT: "Bat", TAMABLE_ANIMAL: "Tamable Animal",
  OCELOT: "Ocelot", WOLF: "Wolf", PIG: "Pig", RABBIT: "Rabbit", SHEEP: "Sheep", VILLAGER: "Villager",
  ENDERMAN: "Ender Man", ZOMBIE: "Zombie", BLAZE: "Blaze", SPIDER: "Spider", CREEPER: "Creeper", GHAST: "Ghast",
  SLIME: "Slime", SKELETON: "Skeleton", WITCH: "Witch", IRON_GOLEM: "Iron Golem", WITHER: "Wither Boss",
  WITHER_SKULL: "Wither Skull", GUARDIAN: "Guardian", BOAT: "Boat", ABSTRACT_MINECART: "Abstract Minecart",
  COMMAND_BLOCK_MINECART: "Minecart Command Block", FURNACE_MINECART: "Minecart Furnace", ITEM: "Item Entity",
  ARROW: "Abstract Arrow", FIREWORK_ROCKET: "Firework Rocket Entity", ITEM_FRAME: "Item Frame", END_CRYSTAL: "End Crystal",
};
const TYPE = { BYTE: "Byte", SHORT: "Short", INT: "Integer", FLOAT: "Float", STRING: "String", ITEM: "ItemStack", ROTATIONS: "Rotations", BLOCK_POSITION: "BlockPos" };
const NAMED = { PLAYER_BYTE: "LEGACY_UNUSED", ENDERMAN_BLOCK_DATA: "CARRIED_BLOCK_DATA", END_CRYSTAL_HEALTH: "HEALTH", ENDERMAN_BLOCK_STATE: "CARRIED_BLOCK_ID" };
const out = {}, problems = [];
const re = /^\s*([A-Z0-9_]+)\(([A-Z_]+), (\d+), EntityDataTypes1_8\.([A-Z_]+), (?:(\d+), )?(?:EntityDataTypes1_9\.([A-Z_]+)|null)\)/gm;
let m, count = 0;
while ((m = re.exec(via))) {
  const [, id, viaType, oldIndex, oldType, newIndexRaw, newType] = m;
  const start = CLASS[viaType];
  if (!start || !snap19[start]) { problems.push(`no 1.9 class for ${viaType} (${start})`); continue; }
  if (!TYPE[oldType]) { problems.push(`unknown 1.8 type ${oldType}`); continue; }
  let owner = start, name = NAMED[id];
  if (newType) {
    const newIndex = Number(newIndexRaw ?? oldIndex);
    let found = null;
    for (let c = start; c; c = snap19[c].superClass) {
      const f = snap19[c].fields.find(f => f.index === newIndex);
      if (f) { found = [c, f]; break; }
    }
    if (!found) { problems.push(`${id}: no 1.9 field at index ${newIndex} of ${start}`); continue; }
    owner = found[0];
    name = name || found[1].fieldName;
  } else if (!name) { problems.push(`${id}: needs a name`); continue; }
  (out[owner] ||= []).push({ index: Number(oldIndex), dataType: TYPE[oldType], fieldName: name, defaultValue: "" });
  count++;
}
for (const name of Object.keys(out)) {
  for (let c = snap19[name].superClass; c; c = snap19[c].superClass) out[c] ||= [];
}
const result = { _meta: {
  source: "Derived from ViaVersion's 1.8 -> 1.9 entity data index table (EntityDataIndex1_9); names and class hierarchy taken from the 1.9 snapshot",
  omitsEmptyClasses: true, explicitIndexes: true } };
for (const name of Object.keys(snap19)) {
  if (name.startsWith("_") || !out[name]) continue;
  let parent = snap19[name].superClass;
  while (parent && !out[parent]) parent = snap19[parent].superClass;
  const fields = out[name].sort((a, b) => a.index - b.index);
  const dup = fields.find((f, i) => i > 0 && (f.index === fields[i - 1].index || fields.some((g, j) => j < i && g.fieldName === f.fieldName)));
  if (dup) problems.push(`${name}: duplicate index or name around ${dup.fieldName}`);
  result[name] = { superClass: parent || null, fields };
}
for (const name of Object.keys(out)) if (!result[name]) problems.push(`class ${name} lost`);
fs.writeFileSync(process.argv[4], JSON.stringify(result, null, 2) + "\n");
console.log(`${count} fields in ${Object.keys(result).length - 1} classes`);
if (problems.length) { console.log("PROBLEMS:\n  " + problems.join("\n  ")); process.exit(1); }
