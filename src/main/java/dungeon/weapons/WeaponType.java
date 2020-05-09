package dungeon.weapons;

public enum WeaponType {
        Fists(2, "Bare knuckles"),
        WoodenSword(5 ,"Wooden Sword"),
        IronSword( 7, "Iron Sword"),
        SteelSword(9, "Steel Sword");

        private int cappedLevel;
        private String description;

        WeaponType(int cappedLevel, String description){
            this.cappedLevel = cappedLevel;
            this.description = description;
        }

        public int getCappedLevel() {
            return cappedLevel;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            String[] vowels = "a,e,i,o,u".split(",");
            boolean hasVowel = false;
            for(String vowel: vowels){
                if(this.description.toLowerCase().startsWith(vowel)){
                    hasVowel = true;
                    break;
                }
            }
            return String.format("%s %s.", (hasVowel ? "an" : "a"), this.description);
        }


}
