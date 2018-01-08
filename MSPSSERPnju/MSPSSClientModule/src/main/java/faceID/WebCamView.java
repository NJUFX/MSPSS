package faceID;

/**
 * Created by thinkpad on 2018/1/7.
 *
import com.github.sarxos.webcam.Webcam;
import javafx.collections.XComboBox;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import trapx00.lightx00.client.Client;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


@SuppressWarnings("unchecked")
public class WebCamView extends VBox {
    @FXML private ImageView cameraImage;
    @FXML private JFXComboBox cbCameraOptions;

    private BufferedImage grabbedImage;
    private Webcam selWebCam;
    private boolean stopCamera = false;
    private static final String cameraListPromptText = "选择一个相机";
    private ObjectProperty<Image> imageProperty = new SimpleObjectProperty<>();
    private EventOnCameraInitialized onCameraInitialized = null;

    public WebCamView() {
        System.out.println("Document Module constructed.");
        FXMLLoader loader = new FXMLLoader(Client.class.getResource("/fxml/helpui/WebCamView.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public void setOnCameraInitialized(EventOnCameraInitialized event) {
        this.onCameraInitialized = event;
    }

    @FXML
    public void initialize() {
        initializeCamera();
    }

    protected void initializeCamera() {
        ObservableList<WebCamInfo> options = FXCollections.observableArrayList();
        int webCamCounter = 0;
        for (Webcam webcam : Webcam.getWebcams()) {
            WebCamInfo webCamInfo = new WebCamInfo();
            webCamInfo.setWebCamIndex(webCamCounter);
            webCamInfo.setWebCamName(webcam.getName());
            options.add(webCamInfo);
            webCamCounter++;
        }
        cbCameraOptions.setItems(options);
        cbCameraOptions.setPromptText(cameraListPromptText);
        cbCameraOptions.getSelectionModel().selectedItemProperty().addListener((ChangeListener<WebCamInfo>) (observableValue, oldValue, newValue) -> {
            if (newValue != null) {
                System.out.println("WebCam Index: " + newValue.getWebCamIndex() + ": WebCam Name:" + newValue.getWebCamName());
                initializeWebCam(newValue.getWebCamIndex());
            }
        });
        cbCameraOptions.getSelectionModel().selectFirst();
    }

    public byte[] acquireImage() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(grabbedImage, "jpg", baos);
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    protected void initializeWebCam(final int webCamIndex) {
        Task<Void> webCamInitializer = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                if (selWebCam == null) {
                    selWebCam = Webcam.getWebcams().get(webCamIndex);
                    selWebCam.open();
                } else {
                    closeCamera();
                    selWebCam = Webcam.getWebcams().get(webCamIndex);
                    selWebCam.open();
                }
                startWebCamStream();
                return null;
            }

        };
        new Thread(webCamInitializer).start();
    }

    protected void startWebCamStream() {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                if (onCameraInitialized != null) {
                    onCameraInitialized.cameraInitialized();
                }
                while (!stopCamera) {
                    try {
                        if ((grabbedImage = selWebCam.getImage()) != null) {
                            Platform.runLater(() -> {
                                final Image mainImage = SwingFXUtils.toFXImage(grabbedImage, null);
                                imageProperty.set(mainImage);

                            });
                            grabbedImage.flush();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                return null;
            }

        };
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
        cameraImage.imageProperty().bind(imageProperty);

    }

    public void closeCamera() {
        if (selWebCam != null) {
            selWebCam.close();
        }
    }

    public void stopCamera() {
        stopCamera = true;
    }

    public void startCamera() {
        stopCamera = false;
        startWebCamStream();
    }

    public void disposeCamera() {
        stopCamera = true;
        closeCamera();
    }
}
 */