# Guide rapide MoreDisc (Fabric API)

## Ou mettre tes textures

Chaque disque utilise cette texture:

- `src/main/resources/assets/moredisc/textures/item/disque_christmas.png`
- `src/main/resources/assets/moredisc/textures/item/disque_femboy.png`
- `src/main/resources/assets/moredisc/textures/item/disque_gimme_more.png`

Format recommande: PNG carre (16x16, 32x32 ou 64x64).

## Ou mettre tes musiques

Place les fichiers `.ogg` ici:

- `src/main/resources/assets/moredisc/sounds/records/`

Noms attendus:

- `all_i_want_for_christmas_is_you.ogg`
- `femboy_feat_erisu.ogg`
- `gimme_more.ogg`

## Ou modifier les infos des disques

- Enregistrement des items et rarete: `src/main/java/fr/chavi/moredisc/ModDiscs.java`
- Enregistrement des sound events: `src/main/java/fr/chavi/moredisc/ModSounds.java`
- Duree/comparateur/description jukebox: `src/main/resources/data/moredisc/jukebox_song/*.json`
- Texte affiche en jeu: `src/main/resources/assets/moredisc/lang/fr_fr.json` et `src/main/resources/assets/moredisc/lang/en_us.json`
- Recettes de craft: `src/main/resources/data/moredisc/recipe/*.json`

## Build et test

- `.\gradlew.bat build`
- `.\gradlew.bat runClient`
