package assign200471302;

import java.util.Scanner;

public class AdventureDesigner {
    static SceneTree sceneTree;
    static Scanner scanner;


    //the entrance of program
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        try {
            System.out.println("Createing a story...");
            System.out.print("Please enter a title:");
            String title = scanner.nextLine();
            System.out.print("Please enter a scene:");
            String scene = scanner.nextLine();
            System.out.println("Scene #1 added.\n");
            sceneTree = new SceneTree(title, scene);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //loop to select opt for menu
        while (true) {
            try {
                printMenu();
                System.out.print("Please enter a selection:");
                String opt = scanner.nextLine();
                doActionForDiffOpt(opt);
            } catch (IllegalArgumentException e) {
                System.out.println("Please input correct selection");
            } catch (QuitAdventureException e1) {
                System.out.println("Program terminating normally...");
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            scanner.close();
        } catch (Exception e) {

        }
    }

    //process the selection
    private static void doActionForDiffOpt(String opt) {
        switch (opt) {
            case "A":
                doActionForAddScene();
                break;
            case "R":
                doActionForRemoveScene();
                break;
            case "S":
                sceneTree.cursor.displayFullScene();
                break;
            case "P":
                System.out.println(sceneTree.toString());
                break;
            case "B":
                doActionForBackAScene();
                break;
            case "F":
                doActionForGoForwardAScene();
                break;
            case "G":
                playGame();
                break;
            case "N":
                System.out.println(sceneTree.getPathFromRoot());
                break;
            case "M":
                doActionForMoveAScene();
                break;
            case "Q":
                throw new QuitAdventureException();
            default:
                throw new IllegalArgumentException();
        }
    }

    private static void doActionForRemoveScene() {
        System.out.print("Please enter an option:");
        String opt = scanner.nextLine();
        try {
            sceneTree.removeScene(opt);
        } catch (NoSuchNodeException e) {
            System.out.println("That option does not exist.");
        }
    }

    private static void doActionForMoveAScene() {
        System.out.print("Move current scene to:");
        String id = scanner.nextLine();
        try {
            sceneTree.moveScene(Integer.valueOf(id));
        } catch (NoSuchNodeException e) {
            System.out.println("There is not a scene node with sceneId:" + id);
        } catch (NumberFormatException e) {
            System.out.println("Please input the correct scene Id");
        }

    }

    private static void doActionForBackAScene() {
        try {
            sceneTree.moveCursorBackwards();
        } catch (NoSuchNodeException e) {
            System.out.println("the current node does not have a parent");
        }
    }

    private static void doActionForGoForwardAScene() {
        System.out.print("Which option do you wish to go to:");
        String opt = scanner.nextLine();
        try {
            sceneTree.moveCursorForwards(opt);
        } catch (NoSuchNodeException e) {
            System.out.println("That option does not exist.");
        }

    }

    private static void doActionForAddScene() {
        System.out.print("Please enter a title:");
        String title = scanner.nextLine();
        System.out.print("Please enter a scene:");
        String des = scanner.nextLine();
        try {
            sceneTree.addNewNode(title, des);
            System.out.println("Scene #" + SceneNode.numScenes + " added.\n");
        }catch (FullSceneException e){
            SceneNode.numScenes--;
            System.out.println("You cannot add another scene!");
        }
    }

    public static void printMenu() {
        System.out.println(
                "A) Add Scene\n" +
                        "R) Remove Scene\n" +
                        "S) Show Current Scene\n" +
                        "P) Print Adventure Tree\n" +
                        "B) Go Back A Scene\n" +
                        "F) Go Forward A Scene\n" +
                        "G) Play Game\n" +
                        "N) Print Path To Cursor\n" +
                        "M) Move Scene\n" +
                        "Q) Quit\n"
        );
    }

    public static void playGame() {
        System.out.println("Now beginning game...");
        SceneNode gamenode = sceneTree.root;
        playGame(gamenode);
    }

    private static void playGame(SceneNode node) {
        while (true) {
            node.displayScene();
            if (node.isEnding()) {
                System.out.println("The End");
                System.out.println("Returning back to creation mode...");
                break;
            }
            System.out.print("Please enter an option: ");
            String opt = scanner.nextLine();
            if (opt.equals("A") && node.left != null) node = node.left;
            else if (opt.equals("B") && node.middle != null) node = node.middle;
            else if (opt.equals("C") && node.right != null) node = node.right;
            else {
                System.out.println("That option does not exist.");
            }
        }
    }
}
