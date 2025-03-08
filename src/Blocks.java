import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Blocks {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pixel art");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 900, 916);

        final int[] keepCoords = {0,0,0};


        Color[][] blocks = {{new Color(70, 70, 70), new Color(120, 120, 120), new Color(180, 180, 180)}, {new Color(255, 50, 0), new Color(255, 120, 0), new Color(255, 200, 0)}, {new Color(0, 50, 0), new Color(0, 120, 0), new Color(0, 200, 0)}, {new Color(0, 50, 255), new Color(0, 120, 255), new Color(0, 200, 255)}, {new Color(160, 255, 255, 70), new Color(180, 255, 255, 70), new Color(200, 255, 255, 70)}};

        byte[][][] world = new byte[8][8][8];

        final int[] X = {0};
        final int[] Y = {0};
        final int[] Z = {0};


        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                world[keepCoords[0]][keepCoords[1]][keepCoords[2]] &=7;
                keepCoords[0] = X[0];
                keepCoords[1] = world.length - 1 - Y[0];
                keepCoords[2] = world.length - 1 - Z[0];
                world[X[0]][world.length - 1 - Y[0]][world.length - 1 - Z[0]] |= 8;

                for (int z = 0; z < world.length; z++) {
                    for (int y = world[z].length - 1; y >= 0; y--) {
                        for (int x = world[z][y].length - 1; x >= 0; x--) {
                            if (world[z][y][x] == 0) {continue;}
                            if (world[z][y][x] == 8) {
                                drawAir(g, 40 * x + 40 * z + 70, 20 * z + 50 * y - 20 * x + 140, 20);
                                continue;
                            }
                            boolean bool = (world[z][y][x] & (1 << 3)) != 0;
                            drawCube(g, 40 * x + 40 * z + 70, 20 * z + 50 * y - 20 * x + 140, blocks[(world[z][y][x] & 7) - 1], 20, bool);
                        }
                    }
                }
            }
        };
        panel.setBounds(100, 130, 900, 900);

        JSlider x = new JSlider(0, world.length - 1, 0);
        x.setPaintTicks(true);
        x.setPaintLabels(true);
        x.setMinorTickSpacing(1);
        x.setMajorTickSpacing(1);
        x.setBounds(0, 50, 200, 40);
         x.addChangeListener(e -> {
            X[0] = x.getValue();
            panel.updateUI();
        });

        JSlider y = new JSlider(0, world.length - 1, 0);
        y.setPaintTicks(true);
        y.setPaintLabels(true);
        y.setMinorTickSpacing(1);
        y.setMajorTickSpacing(1);
        y.setBounds(0, 10, 200, 40);
        y.addChangeListener(e -> {
            Y[0] = y.getValue();
            panel.updateUI();
        });

        JSlider z = new JSlider(0, world.length - 1, 0);
        z.setPaintTicks(true);
        z.setPaintLabels(true);
        z.setMinorTickSpacing(1);
        z.setMajorTickSpacing(1);
        z.setBounds(0, 90, 200, 40);
        z.addChangeListener(e -> {
            Z[0] = z.getValue();
            panel.updateUI();
        });

        JComboBox<String> block = new JComboBox<>(new String[]{"air", "stone", "lava", "leaves", "ice", "glass"});
        block.setBounds(200, 0, 100, 60);

        JButton set = new JButton("set");
        set.addActionListener(e -> {
            world[x.getValue()][world.length - 1 - y.getValue()][world.length - 1 - z.getValue()] = (byte) block.getSelectedIndex();
            panel.repaint();
        });
        set.setBounds(300, 0, 60, 60);

        JButton clear = new JButton("clear");
        clear.addActionListener(e -> {
            int s = JOptionPane.showConfirmDialog(frame,"Are you sure you want to clear the world?");
            if (s != 0){return;}
            for (int z_ = 0; z_ < world.length; z_++) {
                for (int y_ = world[z_].length - 1; y_ >= 0; y_--) {
                    for (int x_ = world[z_][y_].length - 1; x_ >= 0; x_--) {
                        world[x_][y_][z_] = 0;
                    }
                }
            }
            panel.updateUI();
        });
        clear.setBounds(360, 0, 100, 60);


        frame.add(x);
        frame.add(y);
        frame.add(z);
        frame.add(block);
        frame.add(set);
        frame.add(clear);

        frame.add(panel);
        panel.setVisible(true);

        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void drawCube(Graphics g, int x, int y, Color[] _3_colors, int size) {
        g.setColor(_3_colors[0]);
        g.fillPolygon(new int[]{0 * size + x, 0 * size + x, 2 * size + x, 2 * size + x}, new int[]{(int) (3.5 * size + y), 1 * size + y, 2 * size + y, (int) (4.5 * size + y)}, 4);
        g.setColor(_3_colors[1]);
        g.fillPolygon(new int[]{2 * size + x, 2 * size + x, 4 * size + x, 4 * size + x}, new int[]{(int) (4.5 * size + y), 2 * size + y, 1 * size + y, (int) (3.5 * size + y)}, 4);
        g.setColor(_3_colors[2]);
        g.fillPolygon(new int[]{0 * size + x, 2 * size + x, 4 * size + x, 2 * size + x}, new int[]{1 * size + y, 0 * size + y, 1 * size + y, 2 * size + y}, 4);
    }

    public static void drawCube(Graphics g, int x, int y, Color[] _3_colors, int size, boolean isSelected) {
        g.setColor(_3_colors[0]);
        g.fillPolygon(new int[]{0 * size + x, 0 * size + x, 2 * size + x, 2 * size + x}, new int[]{(int) (3.5 * size + y), 1 * size + y, 2 * size + y, (int) (4.5 * size + y)}, 4);
        g.setColor(_3_colors[1]);
        g.fillPolygon(new int[]{2 * size + x, 2 * size + x, 4 * size + x, 4 * size + x}, new int[]{(int) (4.5 * size + y), 2 * size + y, 1 * size + y, (int) (3.5 * size + y)}, 4);
        g.setColor(_3_colors[2]);
        g.fillPolygon(new int[]{0 * size + x, 2 * size + x, 4 * size + x, 2 * size + x}, new int[]{1 * size + y, 0 * size + y, 1 * size + y, 2 * size + y}, 4);
        if (!isSelected) {
            return;
        }
        g.setColor(Color.BLACK);
        g.drawPolygon(new int[]{0 * size + x, 2 * size + x, 4 * size + x, 4 * size + x, 2 * size + x, 0 * size + x}, new int[]{1 * size + y, 0 * size + y, 1 * size + y, (int) (3.5 * size + y), (int) (4.5 * size + y), (int) (3.5 * size + y)}, 6);
    }

    public static void drawAir(Graphics g, int x, int y, int size) {
        g.setColor(Color.BLACK);
        g.drawPolygon(new int[]{0 * size + x, 2 * size + x, 4 * size + x, 4 * size + x, 2 * size + x, 0 * size + x}, new int[]{1 * size + y, 0 * size + y, 1 * size + y, (int) (3.5 * size + y), (int) (4.5 * size + y), (int) (3.5 * size + y)}, 6);
    }
}
