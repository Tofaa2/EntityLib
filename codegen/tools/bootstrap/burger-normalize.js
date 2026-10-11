#!/usr/bin/env node
'use strict';
const fs = require('fs');
const path = require('path');
const { execFileSync } = require('child_process');

const S = __dirname;
const BURGER_DIR = path.join(S, 'burger');
const OUT_DIR = path.join(S, 'burger-snapshots');
const KENNY_REF = path.join(S, 'kenny', '1.14.4.json');
const REPORT = path.join(S, 'burger-normalize-report.json');
const ARGS = new Set(process.argv.slice(2));
const OFFLINE = ARGS.has('--offline');
const SUPPLEMENTS = !ARGS.has('--no-supplements');

const WANTED = ['1.9', '1.9.1', '1.9.2', '1.9.4', '1.10', '1.10.2', '1.11', '1.11.2', '1.12', '1.12.1', '1.12.2',
  '1.13', '1.13.1', '1.13.2', '1.14', '1.14.1', '1.14.2', '1.14.3', '1.14.4'];
const ALIGN_ONLY = '1.14.4';

const TYPES = {
  Byte: 'Byte', VarInt: 'Integer', Float: 'Float', String: 'String', Chat: 'Component',
  OptChat: 'Optional<Component>', Slot: 'ItemStack',
  OptSlot: 'ItemStack',
  Boolean: 'Boolean', Rotations: 'Rotations', BlockPos: 'BlockPos', OptBlockPos: 'Optional<BlockPos>',
  Facing: 'Direction', OptUUID: 'Optional<UUID>', OptBlockState: 'Optional<BlockState>',
  BlockState: 'Optional<BlockState>', NBT: 'CompoundTag', Particle: 'ParticleOptions',
  VillagerData: 'VillagerData', OptVarInt: 'OptionalInt', Pose: 'Pose',
};

const ENTITY_NAMES = {
  '~abstract_entity': 'Entity', '~abstract_living': 'Living Entity', '~abstract_insentient': 'Mob',
  '~abstract_creature': 'Pathfinder Mob', '~abstract_ageable': 'Agable Mob', '~abstract_animal': 'Animal',
  '~abstract_monster': 'Monster', '~abstract_tameable': 'Tamable Animal', '~abstract_minecart': 'Abstract Minecart',
  Mob: 'Mob', Monster: 'Monster',
  AreaEffectCloud: 'Area Effect Cloud', ArmorStand: 'Armor Stand', Arrow: 'Arrow', Bat: 'Bat', Blaze: 'Blaze',
  Boat: 'Boat', CaveSpider: 'Cave Spider', Chicken: 'Chicken', Cow: 'Cow', Creeper: 'Creeper',
  DragonFireball: 'Dragon Fireball', EnderCrystal: 'End Crystal', EnderDragon: 'Ender Dragon', Enderman: 'Ender Man',
  Endermite: 'Endermite', EntityHorse: 'Horse', EyeOfEnderSignal: 'Eye Of Ender', FallingSand: 'Falling Block Entity',
  Fireball: 'Large Fireball', FireworksRocketEntity: 'Firework Rocket Entity', Ghast: 'Ghast', Giant: 'Giant',
  Guardian: 'Guardian', Item: 'Item Entity', ItemFrame: 'Item Frame', LavaSlime: 'Magma Cube',
  LeashKnot: 'Leash Fence Knot Entity', MinecartChest: 'Minecart Chest', MinecartCommandBlock: 'Minecart Command Block',
  MinecartFurnace: 'Minecart Furnace', MinecartHopper: 'Minecart Hopper', MinecartRideable: 'Minecart',
  MinecartSpawner: 'Minecart Spawner', MinecartTNT: 'Minecart TNT', MushroomCow: 'Mushroom Cow', Ozelot: 'Ocelot',
  Painting: 'Painting', Pig: 'Pig', PigZombie: 'Pig Zombie', PolarBear: 'Polar Bear', PrimedTnt: 'Primed Tnt',
  Rabbit: 'Rabbit', Sheep: 'Sheep', Shulker: 'Shulker', ShulkerBullet: 'Shulker Bullet', Silverfish: 'Silverfish',
  Skeleton: 'Skeleton', Slime: 'Slime', SmallFireball: 'Small Fireball', SnowMan: 'Snow Golem', Snowball: 'Snowball',
  SpectralArrow: 'Spectral Arrow', Spider: 'Spider', Squid: 'Squid', ThrownEgg: 'Thrown Egg',
  ThrownEnderpearl: 'Thrown Enderpearl', ThrownExpBottle: 'Thrown Experience Bottle', ThrownPotion: 'Thrown Potion',
  Villager: 'Villager', VillagerGolem: 'Iron Golem', Witch: 'Witch', WitherBoss: 'Wither Boss',
  WitherSkull: 'Wither Skull', Wolf: 'Wolf', XPOrb: 'Experience Orb', Zombie: 'Zombie',
  area_effect_cloud: 'Area Effect Cloud', armor_stand: 'Armor Stand', arrow: 'Arrow', bat: 'Bat', blaze: 'Blaze',
  boat: 'Boat', cat: 'Cat', cave_spider: 'Cave Spider', chest_minecart: 'Minecart Chest', chicken: 'Chicken',
  cod: 'Cod', command_block_minecart: 'Minecart Command Block', commandblock_minecart: 'Minecart Command Block',
  cow: 'Cow', creeper: 'Creeper', dolphin: 'Dolphin', donkey: 'Donkey', dragon_fireball: 'Dragon Fireball',
  drowned: 'Drowned', egg: 'Thrown Egg', elder_guardian: 'Elder Guardian', end_crystal: 'End Crystal',
  ender_crystal: 'End Crystal', ender_dragon: 'Ender Dragon', ender_pearl: 'Thrown Enderpearl', enderman: 'Ender Man',
  endermite: 'Endermite', evoker: 'Evoker', evocation_illager: 'Evoker', evoker_fangs: 'Evoker Fangs',
  evocation_fangs: 'Evoker Fangs', experience_bottle: 'Thrown Experience Bottle', xp_bottle: 'Thrown Experience Bottle',
  experience_orb: 'Experience Orb', xp_orb: 'Experience Orb', eye_of_ender: 'Eye Of Ender',
  eye_of_ender_signal: 'Eye Of Ender', falling_block: 'Falling Block Entity', fireball: 'Large Fireball',
  firework_rocket: 'Firework Rocket Entity', fireworks_rocket: 'Firework Rocket Entity', fishing_bobber: 'Fishing Hook',
  fox: 'Fox', furnace_minecart: 'Minecart Furnace', ghast: 'Ghast', giant: 'Giant', guardian: 'Guardian',
  hopper_minecart: 'Minecart Hopper', horse: 'Horse', husk: 'Husk', illusioner: 'Illusioner',
  illusion_illager: 'Illusioner', iron_golem: 'Iron Golem', villager_golem: 'Iron Golem', item: 'Item Entity',
  item_frame: 'Item Frame', leash_knot: 'Leash Fence Knot Entity', lightning_bolt: 'Lightning Bolt', llama: 'Llama',
  llama_spit: 'Llama Spit', magma_cube: 'Magma Cube', minecart: 'Minecart', mooshroom: 'Mushroom Cow', mule: 'Mule',
  ocelot: 'Ocelot', painting: 'Painting', panda: 'Panda', parrot: 'Parrot', phantom: 'Phantom', pig: 'Pig',
  pillager: 'Pillager', player: 'Player', polar_bear: 'Polar Bear', potion: 'Thrown Potion', pufferfish: 'Pufferfish',
  rabbit: 'Rabbit', ravager: 'Ravager', salmon: 'Salmon', sheep: 'Sheep', shulker: 'Shulker',
  shulker_bullet: 'Shulker Bullet', silverfish: 'Silverfish', skeleton: 'Skeleton', skeleton_horse: 'Skeleton Horse',
  slime: 'Slime', small_fireball: 'Small Fireball', snow_golem: 'Snow Golem', snowman: 'Snow Golem',
  snowball: 'Snowball', spawner_minecart: 'Minecart Spawner', spectral_arrow: 'Spectral Arrow', spider: 'Spider',
  squid: 'Squid', stray: 'Stray', tnt: 'Primed Tnt', tnt_minecart: 'Minecart TNT', trader_llama: 'Trader Llama',
  trident: 'Thrown Trident', tropical_fish: 'Tropical Fish', turtle: 'Turtle', vex: 'Vex', villager: 'Villager',
  vindicator: 'Vindicator', vindication_illager: 'Vindicator', wandering_trader: 'Wandering Trader', witch: 'Witch',
  wither: 'Wither Boss', wither_skeleton: 'Wither Skeleton', wither_skull: 'Wither Skull', wolf: 'Wolf',
  zombie: 'Zombie', zombie_horse: 'Zombie Horse', zombie_pigman: 'Pig Zombie', zombie_villager: 'Zombie Villager',
};

const FIELD_RULES = {
  'Entity': [
    [107, 110, 'SHARED_FLAGS AIR_SUPPLY CUSTOM_NAME CUSTOM_NAME_VISIBLE SILENT'],
    [210, 404, 'SHARED_FLAGS AIR_SUPPLY CUSTOM_NAME CUSTOM_NAME_VISIBLE SILENT NO_GRAVITY'],
  ],
  'Living Entity': [[107, 404, 'LIVING_ENTITY_FLAGS HEALTH EFFECT_COLOR EFFECT_AMBIENCE ARROW_COUNT']],
  'Area Effect Cloud': [
    [107, 110, 'RADIUS COLOR WAITING PARTICLE'],
    [210, 340, 'RADIUS COLOR WAITING PARTICLE PARTICLE_PARAM_1 PARTICLE_PARAM_2'],
  ],
  'Abstract Arrow': [[107, 393, 'ID_FLAGS'], [401, 404, 'ID_FLAGS OWNERUUID']],
  'Boat': [[107, 340, 'HURT HURTDIR DAMAGE TYPE PADDLE_LEFT PADDLE_RIGHT']],
  'Horse': [
    [107, 210, 'FLAGS HORSE_TYPE TYPE_VARIANT OWNER_UUID ARMOR_TYPE'],
    [315, 404, 'TYPE_VARIANT ARMOR_TYPE'],
  ],
  'Firework Rocket Entity': [[107, 315, 'FIREWORKS_ITEM'], [316, 404, 'FIREWORKS_ITEM ATTACHED_TO_TARGET']],
  'Guardian': [[107, 210, 'FLAGS ATTACK_TARGET']],
  'Ocelot': [[107, 404, 'TYPE']],
  'Pig': [[107, 315, 'SADDLE']],
  'Shulker': [[107, 210, 'ATTACH_FACE ATTACH_POS PEEK']],
  'Skeleton': [[107, 210, 'SKELETON_TYPE SWINGING_ARMS']],
  'Abstract Skeleton': [[315, 404, 'SWINGING_ARMS']],
  'Villager': [[107, 404, 'PROFESSION']],
  'Zombie': [
    [107, 210, 'BABY SPECIAL_TYPE CONVERTING ARMS_RAISED'],
    [315, 340, 'BABY SPECIAL_TYPE ARMS_RAISED'],
    [393, 404, 'BABY SPECIAL_TYPE ARMS_RAISED DROWNED_CONVERSION'],
  ],
  'Zombie Villager': [[315, 404, 'CONVERTING PROFESSION']],
  'Evoker': [[315, 316, 'SPELL_CASTING']],
  'Vindicator': [[315, 316, 'FLAGS']],
  'Abstract Illager': [[335, 404, 'FLAGS']],
};

const HAND_NOTES = {
  'Area Effect Cloud.PARTICLE_PARAM_1': ['high', 'MCP PARTICLE_PARAM_1; first particle argument, folded into the Particle type in 1.13'],
  'Area Effect Cloud.PARTICLE_PARAM_2': ['high', 'MCP PARTICLE_PARAM_2; second particle argument, folded into the Particle type in 1.13'],
  'Horse.FLAGS': ['high', 'pre-1.11 monolithic EntityHorse; same field as 1.14.4 Abstract Horse.FLAGS (bit meanings differ, see bitfields)'],
  'Horse.HORSE_TYPE': ['high', 'pre-1.11 horse kind (0 horse, 1 donkey, 2 mule, 3 zombie, 4 skeleton); removed in 1.11 entity split'],
  'Horse.OWNER_UUID': ['high', 'pre-1.11 monolithic EntityHorse; same field as 1.14.4 Abstract Horse.OWNER_UUID'],
  'Horse.ARMOR_TYPE': ['high', 'MCP HORSE_ARMOR; armor kind 0-3, removed in 1.14 (moved to equipment)'],
  'Guardian.FLAGS': ['high', 'pre-1.11 status byte: 0x02 moving/retracting spikes, 0x04 elder; replaced by Boolean MOVING in 1.11'],
  'Ocelot.TYPE': ['medium', 'MCP OCELOT_VARIANT; cat skin 0-3. Removed from Ocelot in 1.14 (Cat.TYPE is a different class)'],
  'Skeleton.SKELETON_TYPE': ['high', 'MCP SKELETON_VARIANT; 0 normal, 1 wither, (1.10) 2 stray; removed in 1.11 entity split'],
  'Skeleton.SWINGING_ARMS': ['high', 'MCP SWINGING_ARMS; moved to Abstract Skeleton in 1.11'],
  'Abstract Skeleton.SWINGING_ARMS': ['high', 'MCP SWINGING_ARMS; removed in 1.14 (replaced by Mob flag 0x04 aggressive)'],
  'Villager.PROFESSION': ['high', 'MCP PROFESSION; VarInt profession id, replaced by VillagerData in 1.14'],
  'Zombie.CONVERTING': ['high', 'MCP CONVERTING; pre-1.11 zombie-villager curing flag, same logical field as 1.14.4 Zombie Villager.CONVERTING'],
  'Zombie.ARMS_RAISED': ['high', 'MCP ARMS_RAISED; removed in 1.14 (replaced by Mob flag 0x04 aggressive)'],
  'Zombie Villager.PROFESSION': ['high', 'MCP PROFESSION; VarInt profession id, replaced by VillagerData in 1.14'],
  'Evoker.SPELL_CASTING': ['high', '1.11.x only: spell byte declared directly on Evoker; same logical field as Spellcaster Illager.SPELL_CASTING (1.12+)'],
  'Vindicator.FLAGS': ['medium', '1.11.x only: byte declared directly on Vindicator, 0x01 = aggressive/has target (MCP AGGRESSIVE)'],
  'Abstract Illager.FLAGS': ['medium', '1.12-1.13: illager status byte, 0x01 = aggressive/has target (MCP AGGRESSIVE); removed in 1.14'],
};

const REUSE_NOTES = [
  ['1.9-1.12.2', 'Entity', 'CUSTOM_NAME', 'wire type String (Optional<Component> since 1.13)'],
  ['1.9-1.12.2', 'Area Effect Cloud', 'PARTICLE', 'wire type Integer (particle id); ParticleOptions since 1.13'],
  ['1.11.2-1.13.2', 'Firework Rocket Entity', 'ATTACHED_TO_TARGET', 'wire type Integer (entity id, 0 = none); OptionalInt since 1.14'],
  ['1.9-1.10.2', 'Zombie', 'SPECIAL_TYPE', 'same accessor as the unused 1.11+ field, but still meaningful here: 1.9 villager profession+1, 1.10 zombie type (1-5 villager, 6 husk)'],
  ['1.9-1.10.2', '(all Slot fields)', '*', 'Burger "OptSlot" (Guava Optional<ItemStack>) emitted as ItemStack; wire format is a plain Slot'],
];

const ALL = [0, 99999];
const BIT_NAMES = {
  'Entity.SHARED_FLAGS': [[...ALL, { 1: 'ON_FIRE', 2: 'CROUCHING', 8: 'SPRINTING', 16: 'SWIMMING', 32: 'INVISIBLE', 64: 'GLOWING', 128: 'FALL_FLYING' }]],
  'Living Entity.LIVING_ENTITY_FLAGS': [[...ALL, { 1: 'USING_ITEM', 2: 'OFF_HAND', 4: 'SPIN_ATTACK' }]],
  'Mob.MOB_FLAGS': [[...ALL, { 1: 'NO_AI', 2: 'LEFT_HANDED', 4: 'AGGRESSIVE' }]],
  'Armor Stand.CLIENT_FLAGS': [[107, 110, { 1: 'SMALL', 2: 'HAS_GRAVITY', 4: 'SHOW_ARMS', 8: 'NO_BASEPLATE', 16: 'MARKER' }],
    [210, 99999, { 1: 'SMALL', 4: 'SHOW_ARMS', 8: 'NO_BASEPLATE', 16: 'MARKER' }]],
  'Abstract Arrow.ID_FLAGS': [[...ALL, { 1: 'CRITICAL', 2: 'NOCLIP', 4: 'SHOT_FROM_CROSSBOW' }]],
  'Bat.FLAGS': [[...ALL, { 1: 'RESTING' }]],
  'Blaze.FLAGS': [[...ALL, { 1: 'CHARGED' }]],
  'Spider.FLAGS': [[...ALL, { 1: 'CLIMBING' }]],
  'Iron Golem.FLAGS': [[...ALL, { 1: 'PLAYER_CREATED' }]],
  'Snow Golem.PUMPKIN': [[210, 99999, { 16: 'HAS_PUMPKIN' }]],
  'Sheep.WOOL': [[...ALL, { 16: 'SHEARED' }]],
  'Tamable Animal.FLAGS': [[...ALL, { 1: 'SITTING', 4: 'TAME' }]],
  'Wolf.FLAGS': [[...ALL, { 2: 'ANGRY' }]],
  'Horse.FLAGS': [[107, 210, { 2: 'TAME', 4: 'SADDLE', 8: 'CHEST', 16: 'BRED', 32: 'EATING', 64: 'STANDING' }]],
  'Abstract Horse.FLAGS': [[315, 99999, { 2: 'TAME', 4: 'SADDLE', 8: 'BRED', 16: 'EATING', 32: 'STANDING', 64: 'OPEN_MOUTH' }]],
  'Guardian.FLAGS': [[107, 210, { 2: 'MOVING', 4: 'ELDER' }]],
  'Fox.FLAGS': [[...ALL, { 1: 'SITTING', 4: 'CROUCHING', 8: 'INTERESTED', 16: 'POUNCING', 32: 'SLEEPING', 64: 'FACEPLANTED', 128: 'DEFENDING' }]],
  'Panda.FLAGS': [[...ALL, { 2: 'SNEEZING', 4: 'ROLLING', 8: 'SITTING', 16: 'ON_BACK' }]],
};

const BITFIELD_FIELD_OVERRIDE = {
  'Abstract Arrow': 'ID_FLAGS',
  'Panda': 'FLAGS',
  'Wolf': 'FLAGS',
};

function supplements(protocol) {
  if (protocol >= 393) return [];
  const player = [
    ['Float', 'PLAYER_ABSORPTION', '0'], ['Integer', 'SCORE', '0'],
    ['Byte', 'PLAYER_MODE_CUSTOMISATION', '0'], ['Byte', 'PLAYER_MAIN_HAND', '1'],
  ];
  if (protocol >= 335) player.push(['CompoundTag', 'SHOULDER_LEFT', 'Empty'], ['CompoundTag', 'SHOULDER_RIGHT', 'Empty']);
  return [
    { name: 'Player', superClass: 'Living Entity', fields: player },
    { name: 'Fishing Hook', superClass: 'Entity', fields: [['Integer', 'HOOKED_ENTITY', '0']] },
  ];
}

const problems = [];
const problem = (v, msg) => { problems.push(`[${v}] ${msg}`); };

function loadBurger(version) {
  const file = path.join(BURGER_DIR, version + '.json');
  if (!fs.existsSync(file)) {
    if (OFFLINE) return null;
    fs.mkdirSync(BURGER_DIR, { recursive: true });
    try {
      execFileSync('curl', ['-s', '-f', '-o', file, `https://pokechu22.github.io/Burger/${version}.json`], { stdio: 'ignore' });
    } catch (e) {
      if (fs.existsSync(file)) fs.unlinkSync(file);
      return null;
    }
  }
  return JSON.parse(fs.readFileSync(file, 'utf8'))[0];
}

const kenny = JSON.parse(fs.readFileSync(KENNY_REF, 'utf8'));
function kennyAncestors(name) {
  const out = [];
  let c = kenny[name] && kenny[name].superClass;
  while (c) { out.push(c); c = kenny[c] ? kenny[c].superClass : null; }
  return out;
}
const kennyDepth = n => kennyAncestors(n).length;

function stringifyDefault(d) {
  if (d === undefined || d === null) return '';
  if (typeof d === 'object') return JSON.stringify(d);
  return String(d);
}

function buildGraph(version, burger) {
  const ents = burger.entities.entity;
  const classes = new Map();
  const node = obf => {
    if (!classes.has(obf)) classes.set(obf, { obf, parent: undefined, data: null, bitfields: [], entityKeys: [], descendants: new Set() });
    return classes.get(obf);
  };
  const setParent = (n, parentObf, ctx) => {
    if (n.parent === undefined) n.parent = parentObf;
    else if (n.parent !== parentObf) problem(version, `class ${n.obf} has inconsistent parents ${n.parent} vs ${parentObf} (${ctx})`);
  };
  for (const key of Object.keys(ents).sort()) {
    const e = ents[key];
    const md = e.metadata || [];
    let prev = null;
    md.forEach((m, i) => {
      if (m.entity !== undefined) {
        if (i !== 0) problem(version, `${key}: inherit reference at position ${i}`);
        const p = ents[m.entity];
        if (!p) { problem(version, `${key}: parent entity ${m.entity} missing`); return; }
        if (p.class !== m.class) problem(version, `${key}: parent ref class ${m.class} != ${m.entity}.class ${p.class}`);
        prev = p.class;
      } else {
        const n = node(m.class);
        setParent(n, prev, key);
        const sig = JSON.stringify(m.data || []);
        if (n.data === null) { n.data = m.data || []; n.bitfields = m.bitfields || []; }
        else if (JSON.stringify(n.data) !== sig) problem(version, `class ${m.class} has differing field lists (${key})`);
        prev = m.class;
      }
    });
    const own = node(e.class);
    if (prev !== e.class) setParent(own, prev, key);
    else if (own.parent === undefined) own.parent = null;
    if (own.data === null) own.data = [];
    own.entityKeys.push(key);
  }
  for (const n of classes.values()) { if (n.parent === undefined) n.parent = null; if (n.data === null) n.data = []; }
  for (const n of classes.values()) {
    for (const key of n.entityKeys) {
      if (key.startsWith('~')) continue;
      let c = n; const seen = new Set();
      while (c && !seen.has(c.obf)) { seen.add(c.obf); c.descendants.add(key); c = c.parent ? classes.get(c.parent) : null; }
    }
  }
  return classes;
}

function nameClasses(version, classes) {
  const names = new Map();
  const how = new Map();
  for (const n of classes.values()) {
    const cands = [...new Set(n.entityKeys.map(k => ENTITY_NAMES[k]).filter(Boolean))];
    for (const k of n.entityKeys) if (!ENTITY_NAMES[k]) problem(version, `entity key "${k}" has no display-name mapping`);
    if (cands.length > 1) problem(version, `class ${n.obf} maps to several names: ${cands.join(', ')}`);
    if (cands.length) { names.set(n.obf, cands[0]); how.set(n.obf, 'registry'); }
  }
  for (const n of [...classes.values()].sort((a, b) => a.obf < b.obf ? -1 : 1)) {
    if (names.has(n.obf)) continue;
    const desc = [...n.descendants].map(k => ENTITY_NAMES[k]).filter(d => d && kenny[d]);
    let common = null;
    for (const d of desc) {
      const anc = kennyAncestors(d);
      common = common === null ? anc : common.filter(a => anc.includes(a));
    }
    const pick = (common || []).slice().sort((a, b) => kennyDepth(b) - kennyDepth(a))[0];
    if (!pick) { problem(version, `intermediate class ${n.obf} (below ${[...n.descendants].join(',')}) could not be named`); names.set(n.obf, `Unknown ${n.obf}`); how.set(n.obf, 'unresolved'); continue; }
    names.set(n.obf, pick); how.set(n.obf, 'lca');
  }
  const seen = new Map();
  for (const [obf, name] of names) {
    if (seen.has(name)) problem(version, `display name "${name}" assigned to both ${seen.get(name)} and ${obf}`);
    seen.set(name, obf);
    const n = classes.get(obf);
    if (how.get(obf) === 'lca' && n.parent) {
      const pn = names.get(n.parent);
      if (kenny[pn] && !kennyAncestors(name).includes(pn)) problem(version, `intermediate "${name}" is not below "${pn}" in kennytv 1.14.4`);
    }
  }
  return { names, how };
}

function nameFields(version, protocol, className, types, layoutLog) {
  const rules = FIELD_RULES[className] || [];
  const rule = rules.find(r => protocol >= r[0] && protocol <= r[1]);
  let names, source;
  if (rule) {
    names = rule[2].split(' '); source = 'rule';
    if (names.length !== types.length) {
      problem(version, `${className}: rule has ${names.length} names but Burger has ${types.length} fields`);
      names = null;
    }
  } else if (kenny[className] && kenny[className].fields.length === types.length
    && kenny[className].fields.every((f, i) => f.dataType === types[i])) {
    names = kenny[className].fields.map(f => f.fieldName); source = 'kennytv-1.14.4-signature';
  } else if (types.length) {
    problem(version, `${className}: no naming rule for layout [${types.join(', ')}] (kennytv 1.14.4: ${kenny[className] ? '[' + kenny[className].fields.map(f => f.dataType).join(', ') + ']' : 'class absent'})`);
  }
  if (!names) { names = types.map((_, i) => `UNKNOWN_${i}`); source = 'unresolved'; }
  if (types.length) layoutLog.push({ className, source, layout: names.map((n, i) => `${n}:${types[i]}`).join(', ') });
  return names;
}

function normalize(version, burger, opts) {
  const protocol = burger.version.protocol;
  const classes = buildGraph(version, burger);
  const { names, how } = nameClasses(version, classes);
  const layoutLog = [];
  const bitNotes = [];
  const out = new Map();
  const depthOf = n => { let d = 0; let c = n; while (c.parent) { d++; c = classes.get(c.parent); } return d; };

  for (const n of classes.values()) {
    const name = names.get(n.obf);
    const types = n.data.map(d => {
      const t = TYPES[d.serializer];
      if (!t) problem(version, `${name}: unknown Burger serializer "${d.serializer}"`);
      return t || d.serializer;
    });
    const fnames = nameFields(version, protocol, name, types, layoutLog);
    const fields = n.data.map((d, i) => ({ index: d.index, dataType: types[i], fieldName: fnames[i], defaultValue: stringifyDefault(d.default) }));
    const entry = { superClass: n.parent ? names.get(n.parent) : null, fields };

    if (n.bitfields.length) {
      const bytes = fields.filter(f => f.dataType === 'Byte');
      let target = null, basis = null;
      if (BITFIELD_FIELD_OVERRIDE[name] && (bytes.length !== 1)) { target = BITFIELD_FIELD_OVERRIDE[name]; basis = 'override'; }
      else if (bytes.length === 1) { target = bytes[0].fieldName; basis = 'single-byte-field'; }
      if (!target) bitNotes.push({ className: name, skipped: true, masks: n.bitfields.map(b => b.mask) });
      else {
        const table = (BIT_NAMES[`${name}.${target}`] || []).find(r => protocol >= r[0] && protocol <= r[1]);
        const masks = [...new Set(n.bitfields.map(b => b.mask))].sort((a, b) => a - b);
        entry.bitfields = { [target]: masks.map(mask => ({ mask, name: (table && table[2][mask]) || null })) };
        bitNotes.push({ className: name, field: target, basis, unnamed: entry.bitfields[target].filter(b => !b.name).map(b => b.mask) });
      }
    }
    out.set(name, { entry, depth: depthOf(n), how: how.get(n.obf) });
  }

  const supplemented = [];
  if (opts.supplements) {
    for (const s of supplements(protocol)) {
      if (out.has(s.name)) { problem(version, `supplement ${s.name} already present in Burger`); continue; }
      if (!out.has(s.superClass)) { problem(version, `supplement ${s.name}: parent ${s.superClass} missing`); continue; }
      let base = 0; let c = s.superClass;
      while (c) { base += out.get(c).entry.fields.length; c = out.get(c).entry.superClass; }
      out.set(s.name, {
        entry: { superClass: s.superClass, fields: s.fields.map((f, i) => ({ index: base + i, dataType: f[0], fieldName: f[1], defaultValue: f[2] })) },
        depth: out.get(s.superClass).depth + 1, how: 'supplement',
      });
      supplemented.push(s.name);
    }
  }

  const snapshot = {};
  for (const [name, v] of [...out.entries()].sort((a, b) => a[1].depth - b[1].depth || (a[0] < b[0] ? -1 : a[0] > b[0] ? 1 : 0))) snapshot[name] = v.entry;
  return { version, protocol, snapshot, layoutLog, bitNotes, supplemented, classHow: Object.fromEntries([...out].map(([k, v]) => [k, v.how])) };
}

function checkContiguous(version, snapshot) {
  const bad = [];
  const count = c => { let t = 0; while (c) { if (!snapshot[c]) { bad.push(`${c}: superClass missing from snapshot`); return NaN; } t += snapshot[c].fields.length; c = snapshot[c].superClass; } return t; };
  for (const [name, e] of Object.entries(snapshot)) {
    const base = e.superClass ? count(e.superClass) : 0;
    e.fields.forEach((f, i) => { if (f.index !== base + i) bad.push(`${name}.${f.fieldName}: index ${f.index}, expected ${base + i}`); });
  }
  return bad;
}

function compareWithKenny(snapshot) {
  const diffs = [];
  const known = new Set(Object.keys(snapshot));
  for (const [name, e] of Object.entries(snapshot)) {
    const k = kenny[name];
    if (!k) { diffs.push(`${name}: not present in kennytv 1.14.4`); continue; }
    const expSuper = kennyAncestors(name).find(a => known.has(a)) || null;
    if (expSuper !== e.superClass) diffs.push(`${name}: superClass "${e.superClass}" vs kennytv (restricted) "${expSuper}"`);
    const a = e.fields.map(f => `${f.index} ${f.dataType} ${f.fieldName}`);
    const b = k.fields.map(f => `${f.index} ${f.dataType} ${f.fieldName}`);
    const len = Math.max(a.length, b.length);
    for (let i = 0; i < len; i++) if (a[i] !== b[i]) diffs.push(`${name}: field #${i} burger "${a[i]}" vs kennytv "${b[i]}"`);
  }
  const kennyOnly = Object.keys(kenny).filter(n => !known.has(n));
  for (const n of kennyOnly) if (kenny[n].fields.length) diffs.push(`${n}: kennytv class WITH fields is missing from Burger`);
  return { diffs, kennyOnlyFieldless: kennyOnly.filter(n => !kenny[n].fields.length) };
}

function range(vs) { return vs.length === 1 ? vs[0] : `${vs[0]} - ${vs[vs.length - 1]}`; }

function main() {
  const missing = [];
  const results = [];
  for (const v of WANTED) {
    const b = loadBurger(v);
    if (!b) { missing.push(v); continue; }
    results.push(normalize(v, b, { supplements: SUPPLEMENTS && v !== ALIGN_ONLY }));
  }
  results.sort((a, b) => a.protocol - b.protocol || WANTED.indexOf(a.version) - WANTED.indexOf(b.version));

  fs.mkdirSync(OUT_DIR, { recursive: true });
  for (const f of fs.readdirSync(OUT_DIR)) if (f.endsWith('.json')) fs.unlinkSync(path.join(OUT_DIR, f));
  const produced = results.filter(r => r.version !== ALIGN_ONLY);
  for (const r of produced) fs.writeFileSync(path.join(OUT_DIR, r.version + '.json'), JSON.stringify(r.snapshot, null, 2) + '\n');
  fs.writeFileSync(path.join(OUT_DIR, 'versions.json'), JSON.stringify(produced.map(r => ({ version: r.version, protocol: r.protocol })), null, 2) + '\n');

  console.log('== versions ==');
  for (const r of results) console.log(`  ${r.version.padEnd(7)} protocol ${String(r.protocol).padEnd(4)} classes ${String(Object.keys(r.snapshot).length).padEnd(4)} fields ${Object.values(r.snapshot).reduce((t, e) => t + e.fields.length, 0)}${r.version === ALIGN_ONLY ? '  (alignment only, not written)' : ''}`);
  console.log(`  missing on Burger: ${missing.join(', ') || 'none'}`);

  console.log('\n== self-check 1: contiguous indexes along the hierarchy ==');
  const contiguity = {};
  let c1 = 0;
  for (const r of results) {
    const bad = checkContiguous(r.version, r.snapshot);
    contiguity[r.version] = bad; c1 += bad.length;
    console.log(`  ${r.version.padEnd(7)} ${bad.length ? 'FAIL' : 'ok'}`);
    for (const b of bad) console.log('      ' + b);
  }

  console.log('\n== self-check 2: normalized Burger 1.14.4 vs kennytv 1.14.4 ==');
  const ref = results.find(r => r.version === ALIGN_ONLY);
  let cmp = { diffs: ['Burger 1.14.4 not available'], kennyOnlyFieldless: [] };
  if (ref) cmp = compareWithKenny(ref.snapshot);
  console.log(`  classes compared: ${ref ? Object.keys(ref.snapshot).length : 0} (with fields: ${ref ? Object.values(ref.snapshot).filter(e => e.fields.length).length : 0}); differences: ${cmp.diffs.length}`);
  for (const d of cmp.diffs) console.log('      ' + d);
  console.log(`  kennytv classes Burger does not know (all field-less): ${cmp.kennyOnlyFieldless.join(', ')}`);

  const hand = new Map();
  const classRanges = new Map();
  const layouts = new Map();
  const bitSkips = new Map(); const bitOverride = new Map(); const bitUnnamed = new Map();
  for (const r of produced) {
    for (const [cls, e] of Object.entries(r.snapshot)) {
      if (!classRanges.has(cls)) classRanges.set(cls, []);
      classRanges.get(cls).push(r.version);
      for (const f of e.fields) {
        const inKenny = kenny[cls] && kenny[cls].fields.some(k => k.fieldName === f.fieldName);
        if (inKenny || r.classHow[cls] === 'supplement') continue;
        const key = `${cls}.${f.fieldName}`;
        if (!HAND_NOTES[key]) problem(r.version, `hand-named field ${key} has no note`);
        const hk = `${key}|${f.dataType}`;
        if (!hand.has(hk)) hand.set(hk, { className: cls, fieldName: f.fieldName, dataType: f.dataType, versions: [], indexes: [], confidence: (HAND_NOTES[key] || [])[0], note: (HAND_NOTES[key] || [])[1] });
        const h = hand.get(hk); h.versions.push(r.version); if (!h.indexes.includes(f.index)) h.indexes.push(f.index);
      }
    }
    for (const l of r.layoutLog) {
      const k = `${l.className} | ${l.layout} | ${l.source}`;
      if (!layouts.has(k)) layouts.set(k, []);
      layouts.get(k).push(r.version);
    }
    for (const b of r.bitNotes) {
      const m = b.skipped ? bitSkips : b.basis === 'override' ? bitOverride : null;
      if (m) { const k = b.className + (b.field ? '.' + b.field : ''); if (!m.has(k)) m.set(k, []); m.get(k).push(r.version); }
      if (b.unnamed && b.unnamed.length) { const k = `${b.className}.${b.field} masks ${b.unnamed.join(',')}`; if (!bitUnnamed.has(k)) bitUnnamed.set(k, []); bitUnnamed.get(k).push(r.version); }
    }
  }
  console.log('\n== hand-named fields (not a kennytv 1.14.4 field of that class) ==');
  for (const h of hand.values()) console.log(`  ${range(h.versions).padEnd(16)} ${h.className}.${h.fieldName} (${h.dataType}) idx ${h.indexes.join('/')} [${h.confidence}] ${h.note}`);
  console.log('\n== kennytv names reused with a different wire type / meaning ==');
  for (const n of REUSE_NOTES) console.log(`  ${n[0].padEnd(16)} ${n[1]}.${n[2]}: ${n[3]}`);
  console.log('\n== classes not in kennytv 1.14.4 ==');
  const nonKenny = [...classRanges.keys()].filter(c => !kenny[c]);
  console.log('  ' + (nonKenny.join(', ') || 'none'));
  console.log('\n== supplements (hand-authored, NOT from Burger) ==');
  const sup = new Map();
  for (const r of produced) for (const s of r.supplemented) { const k = `${s}: ${r.snapshot[s].fields.map(f => `${f.index} ${f.dataType} ${f.fieldName}`).join(', ')}`; if (!sup.has(k)) sup.set(k, []); sup.get(k).push(r.version); }
  if (!sup.size) console.log('  none');
  for (const [k, vs] of sup) console.log(`  ${range(vs).padEnd(16)} ${k}`);
  console.log('\n== bitfields ==');
  for (const [k, vs] of bitOverride) console.log(`  attributed by curated override (not derivable from Burger): ${k} [${range(vs)}]`);
  for (const [k, vs] of bitSkips) console.log(`  skipped (no attributable byte field): ${k} [${range(vs)}]`);
  for (const [k, vs] of bitUnnamed) console.log(`  unnamed: ${k} [${range(vs)}]`);
  const noBits = produced.filter(r => !r.bitNotes.length).map(r => r.version);
  console.log(`  versions whose Burger dump has no bitfield data at all: ${noBits.join(', ') || 'none'}`);

  console.log('\n== unresolved / problems ==');
  if (!problems.length) console.log('  none');
  for (const p of problems) console.log('  ' + p);

  fs.writeFileSync(REPORT, JSON.stringify({
    versions: produced.map(r => ({ version: r.version, protocol: r.protocol })),
    missingOnBurger: missing,
    supplementsEnabled: SUPPLEMENTS,
    checks: { contiguity, kennyDiffs: cmp.diffs, kennyOnlyFieldless: cmp.kennyOnlyFieldless },
    handNamedFields: [...hand.values()],
    reusedNames: REUSE_NOTES,
    supplements: [...sup].map(([k, vs]) => ({ versions: vs, layout: k })),
    layouts: [...layouts].map(([k, vs]) => ({ layout: k, versions: vs })).sort((a, b) => a.layout < b.layout ? -1 : 1),
    classVersions: Object.fromEntries([...classRanges].sort()),
    bitfields: { override: Object.fromEntries(bitOverride), skipped: Object.fromEntries(bitSkips), unnamed: Object.fromEntries(bitUnnamed), versionsWithoutBitfieldData: noBits },
    problems,
  }, null, 2) + '\n');

  const ok = c1 === 0 && cmp.diffs.length === 0 && problems.length === 0;
  console.log(`\nRESULT: ${ok ? 'ALL CHECKS PASSED' : 'CHECKS FAILED'} (contiguity violations ${c1}, 1.14.4 differences ${cmp.diffs.length}, problems ${problems.length})`);
  process.exitCode = ok ? 0 : 1;
}
main();
