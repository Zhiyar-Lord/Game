package com.ghoulstrike.gameinit;
import javax.swing.SwingUtilities;

import com.ghoulstrike.gui.GameWindow;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GameWindow();
        });
    }
}