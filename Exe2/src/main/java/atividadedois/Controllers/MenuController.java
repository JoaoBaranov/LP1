package atividadedois.Controllers;



import javafx.fxml.FXML;
import atividadedois.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


    public class MenuController {

        @FXML
        private Button botaoAnimais;

        @FXML
        public void AbrirTelaAnimais() {
            try {
                Stage stage = (Stage) botaoAnimais.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/atividadedois/animal.fxml"));
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @FXML
        private Button botaoCalcados;

        @FXML
        public void AbrirTelaCalcados() {
            try {
                Stage stage = (Stage) botaoCalcados.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/atividadedois/calcado.fxml"));
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @FXML
        private Button botaoJogos;

        @FXML
        public void AbrirTelaJogos() {
            try {
                Stage stage = (Stage) botaoJogos.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/atividadedois/jogo.fxml"));
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @FXML
        private Button botaoMotos;

        @FXML
        public void AbrirTelaMotos() {
            try {
                Stage stage = (Stage) botaoMotos.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/atividadedois/moto.fxml"));
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @FXML
        private Button botaoCervejas;

        @FXML
        public void AbrirTelaCervejas() {
            try {
                Stage stage = (Stage) botaoCervejas.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/atividadedois/cerveja.fxml"));
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        @FXML
        private Button botaoCarros;

        @FXML
        public void AbrirTelaCarros() {
            try {
                Stage stage = (Stage) botaoCarros.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/atividadedois/carro.fxml"));
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @FXML
        private Button botaoFilmes;

        @FXML
        public void AbrirTelaFilmes() {
            try {
                Stage stage = (Stage) botaoFilmes.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/atividadedois/filme.fxml"));
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @FXML
        private Button botaoInstrumentos;

        @FXML
        public void AbrirTelaInstrumentos() {
            try {
                Stage stage = (Stage) botaoInstrumentos.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/atividadedois/instrumento.fxml"));
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @FXML
        private Button botaoRoupas;

        @FXML
        public void AbrirTelaRoupas() {
            try {
                Stage stage = (Stage) botaoRoupas.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/atividadedois/roupa.fxml"));
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @FXML
        private Button botaoTimes;

        @FXML
        public void AbrirTelaTimes() {
            try {
                Stage stage = (Stage) botaoTimes.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/atividadedois/time.fxml"));
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

