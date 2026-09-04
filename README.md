# JaizMod

This repository is a port of two mods made by Jaiz:

- [JaizMod 1.21.4](https://github.com/Jaiz15/JaizMod-1.21.4)
- [Jaiz Mobs](https://github.com/Jaiz15/jaizmobs-mod)

JaizMod is the bigger continuation and Jaiz Mobs contains an earlier group of creatures, so I brought both of them into one project. The result keeps the JaizMod name and puts the content from the two originals in a single Fabric mod, including the mobs that only existed in the smaller one.

The current target is Minecraft Java 26.2. Updating it was a personal challenge more than anything else. I am ChromusMaster and my part here is the port: making the old code and data work again, fixing crashes, and trying not to change the personality of the original mods along the way.

## What is in JaizMod

There are 32 creatures at the moment. Some are peaceful little ambience mobs, some can be tamed or ridden, and some are very much a bad idea to approach without armor. The mod also has ten wood families, plants, tea, food, blocks, structures, equipment, trims, sulfur ore, pottery-related loot and a number of small Vanilla+ additions.

The 2.3 update adds cumaru, ebony, flamboyant, Atlas cedar, Bismarck palm, cannonball trees and sequoias. They grow in new Overworld chunks and do not rewrite terrain that was already explored. Their leaves can drop the matching saplings, while flamboyant petals and palm fronds provide red dye and thatch. Guarana is treated as a bush instead of another wood set. Its fruit can be planted and roasted, and it is also used for a short-lived guarana soda speed boost.

The End expansion we discussed is not part of this version. I would rather give it enough room to feel useful than add one lonely tree and call it done, so that work is being held for 2.4.0.

The port also has its own advancement tab. It starts small, then follows the creatures, places, tea, equipment and odd discoveries already found in the mod. Nothing outside JaizMod is needed to finish it.

Both original namespaces are still used: `jaizmod` and `jaizmobs`. Keeping them avoids needlessly changing item and entity IDs from the original projects.

A short guide is given to a player the first time they join a world with the mod installed. It points to the Creative tabs and gives a couple of command examples. A more complete player wiki is maintained separately from the source archive.

## Version used by this port

- Minecraft Java 26.2
- Fabric Loader 0.19.3
- Fabric API 0.158.0+26.2
- Fabric Loom 1.17.19
- Java 25
- Terraform Wood API 17.0.1
- TerraBlender 26.2-26.2.0.0.2

## A note about the port

The two mods had to cross several Minecraft versions at once. Entity rendering, saved data, recipes, loot, world generation and quite a few Fabric hooks had all changed. The merged version also needed some duplicated content sorted out; the JaizMod snail was kept because it has the fuller bottle and interaction behaviour.

I have tried to leave the balance and the slightly strange charm of the originals alone. There may still be rough edges, and reports from actual play are useful.

## Credits and rights

All rights and credits for the original mods, code, artwork, sounds, music, creature designs and ideas belong to Jaiz and the original contributors. The names listed in `fabric.mod.json` are kept as part of those credits.

This port does not claim ownership of their work and it is not an official replacement for either original repository. I, ChromusMaster, only made the 26.2 port as a personal challenge.

Please visit the original projects first if you want to see where the mod came from:

- [JaizMod 1.21.4 by Jaiz](https://github.com/Jaiz15/JaizMod-1.21.4)
- [Jaiz Mobs by Jaiz](https://github.com/Jaiz15/jaizmobs-mod)

## License

The included `LICENSE` file still applies. Nothing in this README changes the rights held by the original author or contributors.
