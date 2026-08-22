# JaizMod Continued Megapack

This is the bigger continued version of JaizMod. It joins JaizMod Continued with Jaiz Mobs Continued, so the creatures and features from both projects can live in one install instead of being split between two mods.

The main goal was to keep the original ideas and the slightly odd Vanilla+ feel while getting the old code working on Minecraft Java 26.2. A lot changed between the old versions and 26.2, especially rendering, data files, entity saving and mappings, so this is more than a version number update.

## Current target

- Minecraft Java 26.2
- Fabric Loader 0.19.3
- Fabric API 0.158.0+26.2
- Fabric Loom 1.17.19
- Java 25
- Terraform Wood API 17.0.1
- TerraBlender 26.2-26.2.0.0.2

## Creatures

The pack currently registers 32 creature types:

- Mason Mouth
- Bandit
- Fruit Bat
- Butterfly
- Fire Fly Swarm
- Dragonfly
- Caterpillar
- Snail
- Totem Spirit
- Desert Totem Spirit
- Jungle Totem Spirit
- Frosted Totem Spirit
- Spore Trap
- Void Bull
- Starfish
- Starfish Leader
- Pine Giant
- Driplet
- Stalagtitan
- Calcite Golem
- Cultivator
- Klephtopod
- Hunter Eel
- Aeroblob
- Enderwing
- Molotov Golem
- Geyser Berry
- Warped Truffler
- Crimson Truffler
- Ember Beetle
- Soul Wader
- Strider Hunter

The JaizMod snail was kept as the main snail because it has the fuller bottle and interaction behavior. Its natural spawning also covers lush caves as well as swamps, keeping the useful spawn coverage from the smaller mobs project.

## Other stuff in here

There are new plants, wood sets, food, tea, equipment, blocks, trims, world generation, trades and smaller changes to a few vanilla creatures. The mob half also brings sulfur ore, drops, weapons, armor and spawn eggs.

Both `jaizmod` and `jaizmobs` resource namespaces are kept. The Fabric metadata also provides the old `jaizmobs` mod id, which should make moving from the separate creature project less annoying.

## Update notes

The common and client code are split now. Rendering uses the current render-state pipeline, entity data is saved with the newer value input/output system, and recipes, loot tables, item definitions, tags, equipment assets, trades and worldgen data use the 26.2 layouts.

Some repeated mob attack and render code was shared, attack distances are cached, and the armor set effect no longer checks every armor item on every tick. Runtime mixins were also moved to their current method names because the old targets could leave the game on a black screen during startup.

This is still an old mod brought forward, and it has a lot of content. Balance may be a little strange in places. That was not flattened out on purpose.

## Credits

The original mod, creatures, art, sounds and ideas belong to Jaiz and the people credited in `fabric.mod.json`. This continuation is mostly about keeping all of that playable on newer Minecraft versions.

## License

See the included `LICENSE` file.
