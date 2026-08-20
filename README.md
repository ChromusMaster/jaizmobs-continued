# Jaiz Mobs Continued

Jaiz Mobs Continued is a Fabric continuation of The Jaiz Mobs Mod, originally created by Jaiz.

The mod adds a collection of unusual creatures across the Overworld, Nether and End. Some are hostile, some are useful, and a few are mostly just strange. This project keeps the original creatures and general gameplay while making the mod work on newer Minecraft versions.

## Current version

- Minecraft Java 26.2
- Fabric Loader 0.19.3 or newer
- Fabric API 0.157.0+26.2
- Java 25
- Mod version 2.0.5+26.2

This release is made for Fabric. Forge and NeoForge are not supported.

## What is included

The mod currently has 25 mobs.

In the Overworld you can find Totem Spirits, Spore Traps, Pine Giants, Driplets, Stalagtitans, Snails, Calcite Golems, Cultivators, Klephtopods and Hunter Eels.

The Nether contains Molotov Golems, Geyser Berries, Trufflers, Ember Beetles, Soul Waders and Strider Hunters.

The End has Void Bulls, Aeroblobs, flying Star Fish and the Arch Phantom.

There are also:

- Spawn eggs for every mob
- New food and crafting materials
- Rideable Klephtopods and Aeroblobs
- Tameable Calcite Golems
- New armor and weapons
- Sulfur ore generation
- Mob-specific drops
- New recipes

Some balance choices are a little unusual. That was already part of the original mod and most of it was kept that way.

## Installation

1. Install Fabric Loader for Minecraft 26.2.
2. Install Fabric API.
3. Place the Jaiz Mobs Continued JAR inside the `mods` folder.
4. Start the game using the Fabric profile.

Make sure every installed mod is made for Minecraft 26.2 and Fabric. A Forge or NeoForge mod inside the same instance can cause startup problems even if the filename looks compatible.

## Documentation

The complete Wiki includes:

- Information about every mob
- Natural spawn biomes
- Spawn weights and group sizes
- Attributes and current AI behavior
- Mob drops
- Summon commands
- Spawn egg give commands
- Creative inventory instructions
- The complete migration history from Minecraft 1.20.4 to 26.2

Wiki:

https://github.com/ChromusMaster/jaizmobs-continued/wiki

## Continuation notes

Moving the project to 26.2 required more than changing dependency versions. Entity AI, render states, model animations, item registration, data generation, recipes, loot tables, equipment assets and spawn egg models all needed updates.

The common and client code are now separated correctly for Fabric. Repeated attack and rendering code was also reduced where possible without intentionally changing the original gameplay.

## Known behavior

Some mobs are registered in the monster category but are not automatically aggressive.

Pine Giants mainly retaliate after being attacked. Crimson and Warped Trufflers panic instead of hunting players. Ember Beetles and Soul Waders currently have no direct attack goal.

These are current gameplay behaviors, not installation problems.

## Credits

The original mod, creatures, models, textures and gameplay ideas were created by Jaiz.

This continued version is maintained by ChromusMaster to keep the project available on current Minecraft and Fabric releases.

Source code:

https://github.com/ChromusMaster/jaizmobs-continued

## License

This project uses the MIT License. See the `LICENSE` file for details.