public class Main {

    public static void main(String[] args) {
        Folder
                root = new Folder("root"),
                home = new Folder("home"),
                garam = new Folder("garam"),
                music = new Folder("music"),
                picture = new Folder("picture"),
                doc = new Folder("doc"),
                usr = new Folder("usr");

        File
                track1 = new File("track1"),
                track2 = new File("track2"),
                pic1 = new File("pic1"),
                doc1 = new File("doc1"),
                java = new File("java");

        root.addComponent(home);
        root.addComponent(usr);

        home.addComponent(garam);

        garam.addComponent(music);
        garam.addComponent(picture);
        garam.addComponent(doc);


        music.addComponent(track1);
        music.addComponent(track2);
        picture.addComponent(pic1);
        doc.addComponent(doc1);
        usr.addComponent(java);

        show(root,"");
    }

    /*
    Folder|root
        Folder|home
            Folder|garam
                Folder|music
                    File|track1
                    File|track2
                Folder|picture
                    File|pic1
                Folder|doc
                    File|doc1
        Folder|usr
            File|java
    */

    private static void show(Component component, String tab) {
        System.out.println(tab + component.getClass().getName()+"|"+component.getName());
        if (component instanceof Folder) {
            for (Component c : ((Folder)component).getChildren()) {
                show(c,tab+"    ");
            }
        }
    }


}





