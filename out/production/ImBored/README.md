# ImBored
This is going to be a turn based adventure game where a player needs to clear out levels/rooms.
The objective is to survive as long as possible to get a highscore.
The highscores are displayed at the end of a game and change if any are beaten.

## What each thing should do
- Item
  - Items are not unique, there can be duplicates
  - Have various attributes
    - type
    - rarity (There are the following rarities)
      - Common (70%)
      - Epic (20%)
      - Legendary (8%)
      - Mythic (2%)
    - damage (Below is the range of damage for each rarity)
      - Common: 1-10
      - Epic: 10-15
      - Legendary: 15-20
      - Mythic: 20-50
    - durability (Below is the range of durability for each rarity)
      - Common: 5
      - Epic: 10
      - Legendary: 15
      - Mythic: 30
    - sellPrice
  - Durability and damage is affected by rarity
  - Sell price is type and rarity
- ItemCrafter
  - Craft items, of various types (numbered in terms of sell price)
    - Swords (**2nd Expensive**)
    - Axes (**Most Expensive**)
    - Spears (**Cheapest**)
    - Bows (**2nd Cheapest**)
  - At the end of a stage the ItemCrafter can be used to create a new item, Player can then choose to keep or discard
  - After a player crafts and they choose to discard if they have enough coins then they can reroll
    - Rerolls start at 50 coins and go up 
- Player
  - Players can hold items (inventory)
  - Players can use the ItemCrafter to craft items
  - Players can kill, get hurt by and die to monsters
  - Players have the following attributes
    - health
    - equippedItem
    - level
    - currentDamage (Which is affected by equipped item)
    - coins
      - A player starts with 0 coins
      - coins can be used to purchase rerolls for the ItemCrafter
  - A player gains experience from killing monsters, which can be used to level up
  - When a item breaks, the player loses it
    - So if it is equipped -> equippedItem = None
- Monsters