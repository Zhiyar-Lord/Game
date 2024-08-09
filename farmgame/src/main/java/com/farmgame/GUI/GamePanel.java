package com.farmgame.GUI;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;
import java.awt.Color;

public class GamePanel extends JPanel {
    // screen settings
    private final int OGtileSize = 16; // 16x16 tiles
    private final int tileScale = 3; // scale to 48x48

    private final int tileSize = OGtileSize * tileScale;
    private final int maxScreenCol = 16;
    private final int maxScreenRow = 12;
    private final int screenWidth = tileSize * maxScreenCol; // 768 px
    private final int screenHeight = tileSize * maxScreenRow; // 567 px

    public GamePanel() {
        init();
    }

    public void init() {
        this.setPreferredSize(new DimensionUIResource(screenWidth, screenHeight));

        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // improved rendering perf
    }

}
