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
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.Logger;
import java.io.IOException;


public class App implements Serializable{

    public final static Logger LOGGER = Logger.getLogger(App.class.getName());
    public static class Character implements Serializable{
        private static final long serialVersionUID = -4799551375424315056L;
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
        
        final Character character = new Character("Nomo", 2, "nugget-pollo");
        characters.stream().filter(s -> s.equals(character));

        try {
            secondMain(characters);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        File charactersTXTFile = new File("charactersFile.txt");
        File fileKiller = new File("File.txt");
        fileKiller.delete();
        LOGGER.info("File.txt deleted");
        saveFile(charactersTXTFile, characters);
        testFile();
        loadFile(charactersTXTFile);
        actionPerformed();
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
                writer.write(character.getFullState().concat("/"));
                
            }
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void testFile() throws Exception{
        File file = new File(".\\MyCode.txt");
        
        File dir = new File("Chapter7");
        dir.mkdir();
        
        FileWriter writer = new FileWriter(new File(".\\chapter7\\Jenet.txt"));
        
        BufferedWriter bWriter = new BufferedWriter(writer);
        bWriter.append("Go go Dools\n");
        bWriter.append("Goo");
        
        bWriter.flush();
        bWriter.close();
        
        if (dir.isDirectory()) {
            String[] dirContents = dir.list();
            for (int i = 0; i  < dirContents.length; i++) {
                System.out.println(dirContents[i]);
            }

            System.out.println(dir.getAbsolutePath());
            boolean isDeleted = file.delete();
        } 
    }

    private static void loadFile(File file) {

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] charactersDetails = null;
            while(( line = bufferedReader.readLine()) != null) {
                System.out.println(line);        
                charactersDetails = line.split("/");
            }

            if (charactersDetails != null) {
                for (String details : charactersDetails) {
                    System.out.println(details);
                }
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException ex) {
            ex.printStackTrace();

        } finally {
            try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }

    private static void actionPerformed() {
        boolean[] checkboxState = new boolean[256];
        FileOutputStream fileStream = null;
        ObjectOutputStream outputStream = null;
        for (int i = 0; i < 256; i++) {
            checkboxState[i] = true;
        }

        try {
            fileStream = new FileOutputStream( new File("CheckboxesState.ser"));
            outputStream = new ObjectOutputStream(fileStream);
            outputStream.writeObject(checkboxState);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void restoreCheckboxesState() {
        FileInputStream fileInStream = null;
        ObjectInputStream is = null;
        boolean[] checkboxState = null;

        try {
            fileInStream = new FileInputStream(new File("CheckboxesState.ser"));
            is = new ObjectInputStream(fileInStream);
            checkboxState = (boolean[]) is.readObject();
            for (int i = 0; i < 256; i++) {
                System.out.println( i + ": " + checkboxState[i]);

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            try {
                is.close();
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}