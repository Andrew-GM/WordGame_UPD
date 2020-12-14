package newgame;

import java.awt.Toolkit;
import java.util.*;

public class NewGame {

    public static String UserInput;
    public static int Evil = 0;
    public static int Shield_E = 0;
    public static int Weapon_E = 0;
    public static Scanner input = new Scanner(System.in);
    public static Random random = new Random();
    public static boolean Looper = true;
    public static String[] Weapons = {"dagger", "sword", "stick that really looks like a slingshot", "spear", "club", "flail"};
    public static String RandomWeapon = Weapons[random.nextInt(6)];

    public static void main(String[] args) {
        DeathPopUp Death = new DeathPopUp();
        VictoryPopUp Victory = new VictoryPopUp();
        Victory.setSize(658,336);
        Death.setSize(658,336);
        

        System.out.println("This is the start of your journey.\nYou start with a shield and a " + RandomWeapon + ". \nYou have to defeat the dragon.\nAlong the way there will be choices you make that will impact the outcome of the game.\nChoose wisely and Good Luck!");
        System.out.println("Type either \"1\" or \"2\" to enter your choices.");
        boolean InputChecker = false;
        Choice_Begin();
        if (UserInput.equals("1")) {
            Ans_KillHood();
            Evil = 1;
        }
        if (UserInput.equals("2")) {
            Ans_TalkHood();
        }
        Choice_Path();
        if (UserInput.equals("1")) {
            Ans_Town();
            Death.setVisible(true);
            System.exit(0);
        }
        if (UserInput.equals("2")) {
            Ans_Forest();
        }
        Choice_Bandits();
        if (UserInput.equals("1")) {
            Ans_Fight();
        }
        if (UserInput.equals("2")) {
            Ans_Flee();
        }
        Choice_Hut();
        if (UserInput.equals("1")) {
            Choice_Enter();
            if (UserInput.equals("1")) {
                Shield_E = 1;
            }
            if (UserInput.equals("2")) {
                Weapon_E = 1;
            }
        }
        if (UserInput.equals("2")) {
            Ans_Ignore();
        }
        Choice_Mountain();
        if (UserInput.equals("1")) {
            if (Shield_E == 0) {
                Ans_Block();
                Death.setVisible(true);
                System.exit(0);
            }
            if (Shield_E == 1) {
                Ans_Block_E();
            }
        }
        if (UserInput.equals("2")) {
            Ans_Roll();
        }
        Choice_Action();
        if (UserInput.equals("1")) {
            Choice_ShieldBash();
            if (UserInput.equals("1")) {
                System.out.println("You raise your " + RandomWeapon + " above your head and rain blows down upon the dragon until you are certain that the deed is done...\n"
                        + "CONGRATULATIONS, YOU DEFEATED THE DRAGON!");
                Victory.setVisible(true);
                System.exit(0);
            }
            if (UserInput.equals("2")) {
                if (Evil == 0) {
                    System.out.println("You spare the dragon.\n"
                            + "The dragon sees the goodness in your heart and vows to follow you forever.\n"
                            + "You now have a cool dragon pet that you named singe after the time he almost cremated you alive.\n"
                            + "CONGRATULATIONS, YOU DEFEATED THE DRAGON!                                        (sort of...)");
                    Victory.setVisible(true);
                    System.exit(0);
                }
                if (Evil == 1) {
                    System.out.println("You spare the dragon.\n"
                            + "However, the dragon can smell your sins of murder..."
                            + "The dragon scorches the moment you drop your weapon.");
                    Death.setVisible(true);
                    System.exit(0);
                }
            }
        }
        if (UserInput.equals("2")) {
            Choice_Weapon();
            if (UserInput.equals("1") && (Weapon_E == 1)) {
                System.out.println("After the initial blow of your " + RandomWeapon + " the dragon begins to turn to ash...Magic...\n"
                        + "CONGRATULATIONS, YOU DEFEATED THE DRAGON!");
                Victory.setVisible(true);
                System.exit(0);
            }
            if (UserInput.equals("1")) {
                System.out.println("You raise your " + RandomWeapon + " above your head and rain blows down upon the dragon until you are certain that the deed is done...\n"
                        + "CONGRATULATIONS, YOU DEFEATED THE DRAGON!");
                Victory.setVisible(true);
                System.exit(0);

            }
            if (UserInput.equals("2")) {
                if (Evil == 0) {
                    System.out.println("You spare the dragon.\n"
                            + "The dragon sees the goodness in your heart and vows to follow you forever.\n"
                            + "You now have a cool dragon pet that you named singe after the time he almost cremated you alive.\n"
                            + "CONGRATULATIONS, YOU DEFEATED THE DRAGON!                                        (sort of...)");
                    Victory.setVisible(true);
                    System.exit(0);
                }
                if (Evil == 1) {
                    System.out.println("You spare the dragon.\n"
                            + "However, the dragon can smell your sins of murder..."
                            + "The dragon scorches the moment you drop your weapon.");
                    Death.setVisible(true);
                    System.exit(0);
                }
            }
            

        }

    }

    public static void Loop() {
        while (Looper == true) {
            UserInput = input.next();
            if (UserInput.equals("1") || UserInput.equals("2")) {
                Looper = false;
            } else {
                System.out.println("Enter either \"1\" or \"2\".");
            }
        }
        Looper = true;
    }

    public static void Choice_Begin() {
        System.out.println("");
        System.out.println("You are walking along a path in a bright forest. A hooded figure approaches.");
        System.out.println("What do you want to:"
                + "\n1. Kill him with your " + RandomWeapon + "."
                + "\n2. Speak to him.");
        Loop();       

    }

    public static void Ans_KillHood() {
        System.out.println("");
        System.out.println("You have killed the hooded figure with your " + RandomWeapon + ". What a horrible fate...");
    }

    public static void Ans_TalkHood() {
        System.out.println("");
        System.out.println("You talk to the figure and they warn you not to go through town.\n They quickly scurry off...strange...");
    }

    public static void Choice_Path() {
        System.out.println("");
        System.out.println("The Sun is setting and it is getting dark.\n"
                + "The path you are on splits into two.");
        System.out.println("What do you want to do?:"
                + "\n1. Go through the town."
                + "\n2. Go through the dark forest.");
        Loop();
    }

    public static void Ans_Town() {
        System.out.println("");
        System.out.println("You are walk to the gates of the town where you are then searched by the guards>"
                + "\n They find your shield and " + RandomWeapon + " and you are accused of conspiring against the empire           (\"Which you've never even heard of..?\")");
        System.out.println("You are thrown in prison where you live in harsh conditions where you die a painful death.\n"
                + "Should've just listned to the creepy hooded figure...");
    }

    public static void Ans_Forest() {
        System.out.println("");
        System.out.println("You choose to walk into the dark, cold, eerie forest.\n"
                + "This was smart... right?");
    }

    public static void Choice_Bandits() {
        System.out.println("");
        System.out.println("You walk thourgh the dark forest until you are suddenly surrounded by a group of bandits.");
        System.out.println("What do you want to do?:"
                + "\n1. Fight."
                + "\n2. Flee.");
        Loop();
    }

    public static void Ans_Fight() {
        System.out.println("");
        System.out.println("You pull out your " + RandomWeapon + ", yell and wildly swing it around like you know how to actually use it.\n"
                + "The bandits got confused and ran off...\n"
                + "...Well that was easy.");
    }

    public static void Ans_Flee() {
        System.out.println("You run like your life depends on it, because it probably does.\n"
                + "You manage to escape from the bandits.");
    }

    public static void Choice_Hut() {
        System.out.println("");
        System.out.println("You see a dim light emanating from a small hut."
                + "\nWhat do you want to do?:"
                + "\n1. Enter the hut."
                + "\n2. Ignore the hut.");
        Loop();
    }

    public static void Choice_Enter() {
        System.out.println("You enter and see an oracle saying that they were predicting you coming.\n"
                + "You zone out through most of their (probably very important) monologue but tune back in to hear about some cool enchantments.\n"
                + "What do you do want to do?:"
                + "\n1. Enchant your shield."
                + "\n2. Enchant your " + RandomWeapon + ".");
        Loop();
    }

    public static void Ans_Ignore() {
        System.out.println("");
        System.out.println("You walk past the hut.\n Who knows what mystical wonders could've been in there...");
    }

    public static void Choice_Mountain() {
        System.out.println("You feel a great urge to climb the mountain.\n"
                + "You feel the dragon's presence so you arm yourself for battle.\n"
                + "You enter the den...\n"
                + "The Dragon was ready! It is preparing to fire a blast.\n"
                + "What do you want to do?:"
                + "\n1. Block the blast with your shield"
                + "\n2. Roll out of the way.");
        Loop();
    }

    public static void Ans_Block_E() {
        System.out.println("");
        System.out.println("You raise your shield and the fire is repelled...       Magic.");
    }

    public static void Ans_Block() {
        System.out.println("");
        System.out.println("You raise your shield to block the fire.\n"
                + "You get incinerated... I don't really know what you expected...");
    }

    public static void Ans_Roll() {
        System.out.println("");
        System.out.println("You barely manage to avoid the flames, but you're safe.");
    }

    public static void Choice_Action() {
        System.out.println("The time to counter attack is now.\n"
                + "What do you want to do?:"
                + "\n1. Attack with the shield."
                + "\n2. Attack with your " + RandomWeapon + ".");
        Loop();
    }

    public static void Choice_ShieldBash() {
        System.out.println("");
        System.out.println("You bash the dragon's head with your shield.\n"
                + "It is suprisingly effective and the dragon is stunned.\n"
                + "What do you want to do?:"
                + "\n1. Finish the dragon off."
                + "\n2. Spare the dragon.");
        Loop();
    }

    public static void Choice_Weapon() {
        System.out.println("");
        System.out.println("You bash the dragon's head with your " + RandomWeapon + ".\n"
                + "It is suprisingly effective and the dragon is stunned.\n"
                + "What do you want to do?:"
                + "\n1. Finish the dragon off."
                + "\n2. Spare the dragon.");
        Loop();
    }
}
