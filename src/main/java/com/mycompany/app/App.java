package com.mycompany.app;

import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.io.Serializable;
import java.io.File;
import java.io.BufferedWriter;
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
                .append(" Level: ").append(String.valueOf(level))
                .append(" Weapon: ").append(weapon)
                .toString();
        }

    }
     
    public static void main(String[] args) throws Exception {
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

        LOGGER.info("\n\n Init TXT IO Proccess");
        List<Character> characters = new ArrayList<Character>();
        characters.add(one);
        characters.add(two);
        characters.add(three);

        try {
            secondMain(characters);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 

        saveFile(new File(".\\File.txt"), characters);
        testFile();
    
    }

    private static void secondMain(List<Character> characters) throws Exception {

        FileWriter writer = new FileWriter(
            System.getProperty("user.dir")
            .concat("\\")
            .concat("MyFile.txt")
        );

        for (Character character : characters) {
            writer.write(character.getFullState());
        }
        
        writer.close();
    }

    private static void saveFile(File file, List<Character> characters) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            
            for (Character character : characters) {
                writer.write(character.getFullState().concat("\n"));
            }
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static void testFile() throws Exception{
        File file = new File(".\\MyCode.txt");
        
        File dir = new File("Chapter7");
        dir.mkdir();
        
        FileWriter writer = new FileWriter(new File(".\\chapter7\\Jenet.txt"));
        
        writer.write("Go go Dools");
        writer.close();
        
        if (dir.isDirectory()) {
            String[] dirContents = dir.list();
            for (int i = 0; i  < dirContents.length; i++) {
                System.out.println(dirContents);
            }

            System.out.println(dir.getAbsolutePath());
            boolean isDeleted = file.delete();
        } 
    }
}