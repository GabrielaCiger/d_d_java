# D&D (Java Edition)
This is a text-based adventure game inspired by Dungeons and Dragons. Dive into a fantasy world where you embark on quests, battle monsters, and make choices that shape your character's destiny. Designed in Java, this game brings classic role-playing elements to life.
## Table of Contents
- [Intro](#Intro)
- [Features](#Features)
- [Gameplay](#Gameplay)
- [Running the game](#Running)
- [Spoil alert : Story](#Story)
  
## Intro
This game was developed as part of a Java learning module. The objective was to create a text-based console game in the style of Dungeons and Dragons. The module focused on teaching object-oriented programming (OOP), the fundamentals of Java programming, and integrating our game with a database.

![Main menu](https://github.com/user-attachments/assets/64fd5c1a-c1e5-4da1-9ada-e6bb33dced19)

## Features
This game features a story mode where you begin as a traveler entering a tavern, where you meet a mysterious stranger who prepares you for your quest (but what is your quest? You'll have to find out!). At the end of the game, you have the option to read the concluding story, which presents you with several choices—some of which are unlocked only if you discover a hidden object or remember specific details from your journey. Enemies and objects are depicted using ASCII art.

## Gameplay
For now, the game proposes a player to choose from two types of characters - warrior or a wizard. 
## Heroes
### Warrior
The Warrior is a character with higher maximum life but lower strength. They can only wield combat weapons and defend themselves with shields. Defeating goblins increases the Warrior's strength.
**Starting status of the warrior:**
| Attribute          | Description                |
|--------------------|----------------------------|
| Weapon             | Rusty sword (Attack: 3)   |
| Shield             | Shield (Defense: 2) |
| Max Life           | 10                         |
| Strength           | 10                          |
### Wizard
The Wizard has lower life compared to the Warrior but boasts much higher attack power. They can only cast spells and protect themselves with potions. Defeating evil mages enhances the Wizard's abilities.
**Starting status of the wizard:**
| Attribute          | Description                |
|--------------------|----------------------------|
| Weapon             | Simple spell (Attack: 3)   |
| Shield             | Potion (Defense: 2) |
| Max Life           | 6                         |
| Strength           | 14                          |
## Playing
Players make their choices using a numeric keypad. You can always decide to approach, attack, or flee from an enemy, and you can choose whether to open a secret box and whether to keep the item inside or not.
The goal of the game is to reach the conclusion and discover a secret ending. The final story does not determine whether the player has won or lost.

## Enemies
![Goblin](https://github.com/user-attachments/assets/df73fe77-278e-4c7d-ba6b-58852bd10ce6)

### Goblin
A goblin is a small, grotesque creature characterized by its sharp features and mischievous nature, often found lurking in caves or forests. With a reputation for being cunning and resourceful, goblins are known to engage in theft and trickery, making them both a nuisance and a challenge for adventurers.
| Attribute          | Description                |
|--------------------|----------------------------|
| Weapon             | Wooden Sword (Attack: 1)   |
| Shield             | Leather Armor (Defense: 0) |
| Max Life           | 12                         |
| Strength           | 3                          |
### Evil mage 
An evil mage is a dark sorcerer who wields powerful spells with malevolent intent, often seeking to dominate or destroy those who oppose them. Cloaked in shadowy robes, they are known for their cunning tactics and mastery of forbidden magic, making them formidable adversaries in any confrontation.
| Attribute          | Description                |
|--------------------|----------------------------|
| Weapon             | Cursed amulet (Attack: 3)   |
| Shield             | Satin cloak (Defense: 2) |
| Max Life           | 14                         |
| Strength           | 5                         |
### Dragon
Dragons, once the sole inhabitants of Earth, are majestic and powerful creatures that roam freely, disregarding human territories. Neither friend nor foe, showing them respect may yield favorable outcomes for the player.
| Attribute          | Description                |
|--------------------|----------------------------|
| Weapon             | Fire (Attack: 5)   |
| Shield             | Dragon skin (Defense: 4) |
| Max Life           | 18                         |
| Strength           | 8                         |
### Nymph
Nymphs are non-attackable entities. When approached, they may reveal themselves as either:
- **Siren:** Inflicts negative effects on the player.
- **Mermaid:** Grants positive effects on the player.

## Bonus chests and healing items
Bonus chests in the game contain special items such as weapons, spells, shields, potions, or healing items. Upon opening a chest, players reveal its contents but have the option to choose whether to take the items or leave them behind.
![Key](https://github.com/user-attachments/assets/678c6d6e-baf6-46b8-aae6-7717601576c5)

## Running the Game
> **Attention:** The user must have the Java Development Kit (JDK) installed on their system to run the game. Make sure to verify the installation by running `java -version` in your terminal.

Follow these steps to run the game from your terminal:

1. **Download the Repository:**
   - Go to the GitHub page of the game.
   - Click on the "Code" button and select "Download ZIP".
   - Extract the downloaded ZIP file to your desired location.

2. **Open the Terminal:**
   - Navigate to the folder where you extracted the game files.

3. **Compile the Java Files:**
   - Use the following command to compile the Java files:
     ```bash
     javac *.java
     ```

4. **Run the Game:**
   - After compiling, run the main class of the game:
     ```bash
     java Main
     ```

5. **Enjoy the Game!**
   - Follow the on-screen instructions to start playing.

> **Note:** The appearance of images and text may vary depending on the terminal emulator you are using. These instructions are designed to be compatible with most console environments, but specific commands or outputs may differ slightly based on your system. If you encounter any issues, please refer to your terminal's documentation for further assistance.

## Story
> **Note:** If you don't want to be spoiled before playing, don't read this part!!! You have been warned...

![Intro](https://github.com/user-attachments/assets/05eb05b1-080e-4db5-af07-fd97d4a35e20)

In this Dungeons and Dragons-style game, the player embarks on a journey that begins in a tavern, where they meet an old man named Duncan. He shares tales of a world plagued by misery, where goblins—metaphors for criminals—roam, robbing and killing. As the story unfolds, it becomes clear that these goblins are not monsters but rather people transformed by their own lust and greed. Meanwhile, evil mages, symbolizing politicians, vie for power, and ancient dragons fiercely protect their territories, serving as a metaphor for animals whose habitats are encroached upon by humans.

Duncan gifts the player a magical dice, a powerful artifact that can lead to either death or the secret temple that holds the meaning of life—an essential truth needed to end the world's suffering. As the player traverses the map, they encounter various enemies and discover valuable items along the way. Ultimately, they reach the temple, which features expansive corridors adorned with statues of ancient warriors and wizards—representations of philosophers, scientists, and artists who have positively impacted humanity.

At the end of the corridor lies a room containing a glass table and a golden birdcage. If the player has found a secret key during their quest, they can unlock the glass jewelry box to reveal a scroll with a hidden message: the meaning of life is love, in its many forms. If the key is not found, the player can choose to break the box, but this action will forever conceal the secret, encouraging them to replay the game to find the key—a metaphor for persistence and the idea of revisiting past challenges.

Inside the birdcage is a golden parrot, representing the deep subconscious that inherently knows the meaning of life, which people are born without realizing. The player can pose two questions to the parrot: "What is the meaning of life?"—to which it recites a rhymed poem indicating that love is the answer—or "Why is there so much suffering in the world?" Here, the parrot explains the true nature of goblins, evil mages, and dragons.

If the player remembers Duncan’s name, the parrot recounts a poignant story: after the player leaves the tavern, Duncan himself transforms into a goblin, having once worked for an evil mage and succumbed to false beliefs and lies, ultimately losing his meaning of life at the bottom of an ale mug—an implication of his alcoholism.

In this rich tapestry of metaphor and meaning, the player learns that the path to understanding life is fraught with challenges, choices, and the importance of love.


