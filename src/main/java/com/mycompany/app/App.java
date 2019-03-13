package com.mycompany.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.io.Serializable;

import java.util.logging.Logger;
import java.io.IOException;

public class App {
    public final static Logger LOGGER = Logger.getLogger(App.class.getName());
    public static class Character implements Serializable{
        private String creature;
        private int level;
        private String weapon;

        public Character(String creature, int level, String weapon) {
            this.creature = creature;
            this.level = level;
            this.weapon = weapon;
        }

        public String getCreature() {
            return creature;
        }

        public void setCreature(String creature) {
            this.creature = creature;
        }

        public int getLevel() {
            return level;
        }

        public String getWeapon() {
            return weapon;
        }
        
        public String getFullState() {
            
            return new StringBuilder()
                .append("Creature: ").append(creature)
                .append("Level: ").append(String.valueOf(level))
                .append("Weapon: ").append(weapon)
                .toString();
        }

    }
     
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException{
        LOGGER.info(System.getProperty("user.home"));
        FileOutputStream fileStream = new FileOutputStream(System.getProperty("user.dir")
            .concat("\\")
            .concat("MyGame.ser"));
        
            Character one = new Character("elf", 20, "Knife");
            Character two = new Character("elf", 12, "Sword");
            Character three = new Character("elf", 11, "Knife");
        
        LOGGER.info("Pre Saved Proccess(1): %s".format(one.getFullState()));

        LOGGER.info("Pre Saved Proccess(2): %s".format(two.getFullState()));
        
        LOGGER.info("Pre Saved Process(3): %s".format(three.getFullState()));

        ObjectOutputStream os = new ObjectOutputStream(fileStream);
        os.writeObject(one);
        os.writeObject(two);
        os.writeObject(three);

        os.close();


        ObjectInputStream is = new ObjectInputStream(new FileInputStream(
         System.getProperty("user.dir")
         .concat("\\")
         .concat("MyGame.ser")  
        ));

        one = (Character) is.readObject();
        two = (Character) is.readObject();
        three = (Character) is.readObject();

        LOGGER.info("Post Saved Proccess: %s".format(one.getFullState()));
        LOGGER.info("Post Saved Proccess(2): %s".format(two.getFullState()));
        LOGGER.info("Post Saved Process(3): %s".format(three.getFullState()));
        LOGGER.info("Process Finished Succesfully");
    }

}