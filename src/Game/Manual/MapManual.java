package Game.Manual;

import Game.Main.Game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MapManual extends JPanel {

  public MapManual(Game game) {
    setLayout(new BorderLayout());
    setBackground(Color.GRAY);

    JPanel mapsContainer = new JPanel();
    mapsContainer.setLayout(new BoxLayout(mapsContainer, BoxLayout.PAGE_AXIS));
    mapsContainer.setBackground(Color.GRAY);

    mapsContainer.add(
      createMapPanel(
        "Empty Tile",
        "src/Resource/Images/Map/image_0.png",
        "Empty Tile: No action possible."
      )
    );

    mapsContainer.add(
      createMapPanel(
        "Buildable Tile",
        "src/Resource/Images/Map/image_1.png",
        "Buildable Tile: This is were you can build towers."
      )
    );

    mapsContainer.add(
      createMapPanel(
        "Road",
        "src/Resource/Images/Map/image_5.png",
        "Road: This is were the enemies can walk."
      )
    );

    mapsContainer.add(
      createMapPanel(
        "Start",
        "src/Resource/Images/Map/image_4.png",
        "Start: This is the start of the enemy wave."
      )
    );

    mapsContainer.add(
      createMapPanel(
        "End",
        "src/Resource/Images/Map/image_3.png",
        "End: This is the end of the enemy wave. If they reach that point they deal you damage."
      )
    );

    add(mapsContainer, BorderLayout.CENTER);

    JButton backButton = new JButton("Manual");
    backButton.addActionListener(e -> {
      ManualPage manualPage = new ManualPage(game);
      game.setContentPane(manualPage);
      game.revalidate();
      game.repaint();
    });

    JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    bottomPanel.setBackground(Color.GRAY);
    bottomPanel.add(backButton);
    add(bottomPanel, BorderLayout.SOUTH);
  }

  private JPanel createMapPanel(
    String mapName,
    String imagePath,
    String description
  ) {
    JPanel mapPanel = new JPanel(new BorderLayout(10, 10));
    mapPanel.setBackground(Color.GRAY);
    mapPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    ImageIcon scaledIcon = getScaledImageIcon(imagePath);

    JLabel mapLabel = new JLabel(scaledIcon);
    mapPanel.add(mapLabel, BorderLayout.WEST);

    JLabel descriptionLabel = new JLabel(
      "<html><div style='text-align: left;'>" + description + "</div></html>"
    );
    descriptionLabel.setForeground(Color.WHITE);
    mapPanel.add(descriptionLabel, BorderLayout.CENTER);

    return mapPanel;
  }

  private ImageIcon getScaledImageIcon(String imagePath) {
    ImageIcon originalIcon = new ImageIcon(imagePath);
    Image originalImage = originalIcon.getImage();
    int width = originalIcon.getIconWidth() / 3;
    int height = originalIcon.getIconHeight() / 3;
    Image scaledImage = originalImage.getScaledInstance(
      width,
      height,
      Image.SCALE_SMOOTH
    );
    return new ImageIcon(scaledImage);
  }
  // public String getTileDescription(Tile tile) {
  //     String description = "";

  //     if (tile instanceof Builder) {
  //         description = "Tuile de Construction : Cette tuile est destinée à la construction de tours ou de bâtiments. Elle n'est pas praticable pour les ennemis mais permet au joueur de construire des structures de défense.";
  //     } else if (tile instanceof Empty) {
  //         description = "Tuile Vide : Cette tuile n'a aucune fonction particulière. Elle n'est ni praticable pour les ennemis ni constructible pour le joueur. Elle sert simplement à remplir l'espace de la carte.";
  //     } else if (tile instanceof End) {
  //         description = "Tuile de Fin : Cette tuile marque la fin du parcours que les ennemis doivent atteindre. Elle est praticable pour permettre aux ennemis de terminer leur route.";
  //     } else if (tile instanceof Route) {
  //         description = "Tuile de Route : Cette tuile définit le chemin que les ennemis suivront. Elle est uniquement praticable par les ennemis et ne peut pas être utilisée pour la construction.";
  //     } else if (tile instanceof Start) {
  //         description = "Tuile de Départ : C'est à partir de cette tuile que les ennemis commencent leur avancée. Comme la tuile de Route, elle est uniquement praticable par les ennemis.";
  //     }

  //     return description;
  // }

}
