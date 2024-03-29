    package com.iiitd.stickhero;

    import javafx.application.Application;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Scene;
    import javafx.scene.image.Image;
    import javafx.stage.Stage;

    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.TreeMap;
    import java.util.TreeSet;

    public class StickHero extends Application {
        private static boolean status = false;

        static Username_share user=new Username_share();

        @Override
        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            stage.setTitle("StickHero");
            Image icon = new Image("unnamed.png");

            stage.getIcons().add(icon);
            stage.setHeight(600);
            stage.setWidth(463);
    //        stage.setResizable(false);

            stage.setScene(scene);

            stage.setResizable(false);
    //        stage.sets;
            stage.show();

        }
        public boolean check_if_launch(){
            return this.status;
        }

        public static void main(String[] args) throws IOException, ClassNotFoundException {
            try {
                if(DataBase.deserialize() == null){
                    Player admin = Player.createNewPlayer("Admin","admin","1234");
                DataBase.getPlayerList().add(admin);
                DataBase.serialize(DataBase.getPlayerList());
                }
                status = true;
                launch();

            }
            catch (ClassNotFoundException e) {
                Player admin = Player.createNewPlayer("Admin","admin","1234");
                DataBase.getPlayerList().add(admin);
                DataBase.serialize(DataBase.getPlayerList());
                status = true;
                launch();
            }

            catch (IOException e) {
//                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }
