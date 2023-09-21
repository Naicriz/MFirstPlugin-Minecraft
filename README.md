# MyFirstPlugin | A.K.A. MFP

A Minecraft plugin developed for learning purposes. This plugin is not intended to be used on production servers.
Only for learning purposes and for fun.
You can check how this plugin was developed by looking at the [commits](https://github.com/Naicriz/MyFirstPlugin-Minecraft/commits/core).
---
## Commands

### /fairyfly
- Description: Gives the player the ability to fly for 10 seconds.
- Usage: `/fairyfly`
- Permissions: myfirstplugin.fairyfly

### /die
- Description: Kills the player. Pretty self-explanatory.
- Usage: `/die`
- Permissions: None added.

### /fart or /fart what could be?
- Description: Unclear command. You might want to specify its purpose.
- Usage: `/fart [arg]`
- Permissions: None added.

### /god
- Description: Makes the player invincible.
- Usage: `/god`
- Permissions: None added.

### /setspawn
- Description: Sets the spawn point at the current location in the current world.
- Usage: `/setspawn`
- Permissions: None added.

### /spawn
- Description: Teleports the player to the spawn point.
- Usage: `/spawn`
- Permissions: None added.

### /cmdargs
- Description: Used for testing command arguments.
- Usage: `/cmdargs [args]`
- Permissions: None added.

### /feed
- Description: Feeds the player if needed.
- Usage: `/feed`
- Permissions: None added.

### /testperm
- Description: Tests for see if inherited permissions work.
- Usage: `/testperm [permission]`
- Permissions: myfirstplugin.test

### /set
- Description: set command (and trying more than 1 arg) for everything.
- Usage: /<Command> <joinmsg> <value>
- Permission: myfirstplugin.set

## Listeners

### DeathListener
- Description: Listens for player deaths.

### PlayerListener (onPlayerJoinSteroids )
- Description: Listens for join event and check if the player has been on the server before.

### SpawnListener
- Description: Listens for player respawn events and checks if the player has been on the server.

### XPBottleBreakListener
- Description: Listens for the event when an XP bottle is thrown and explodes.

## Installation

1. Download the latest release from the [releases page](https://github.com/Naicriz/MyMinecraftPlugin/releases).
2. Place the JAR file into your server's `plugins` folder.
3. Restart or reload your server.

## Permissions

- `myplugin.fairyfly`: Permission to use the `/fairyfly` command.
- `myplugin.god`: Permission to use the `/god` command.
- `myplugin.setspawn`: Permission to use the `/setspawn` command.
- `myplugin.spawn`: Permission to use the `/spawn` command.
- `myplugin.cmdargs`: Permission to use the `/cmdargs` command.
- `myplugin.feed`: Permission to use the `/feed` command.
- `myplugin.testperm`: Permission to use the `/testperm` command.

## Configuration

You can customize the plugin's behavior by editing the `config.yml` file.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
