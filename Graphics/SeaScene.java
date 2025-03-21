/*import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SeaScene extends JPanel implements ActionListener {
    private int sunX = 0;  // Starting X position of the sun (off-screen)
    private int sunY = 50; // Y position of the sun (constant in this scenario)
    
    private Timer timer;
    private Bird[] birds;
    
    // Constructor to set up the scene and start the timer
    public SeaScene() {
        timer = new Timer(50, this); // Timer for timelapse effect (sun and birds' movement)
        timer.start();
        
        // Initialize birds with random positions and speeds
        birds = new Bird[5];
        Random rand = new Random();
        for (int i = 0; i < birds.length; i++) {
            birds[i] = new Bird(rand.nextInt(800), rand.nextInt(200), rand.nextInt(5) + 1); // Random start positions and speeds
        }
    }

    // Paint method to render the scene
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Draw sea (bottom half)
        g.setColor(new Color(30, 144, 255)); // Sea blue
        g.fillRect(0, getHeight() / 2, getWidth(), getHeight() / 2);
        
        // Draw sky (top half)
        g.setColor(new Color(135, 206, 235)); // Sky blue
        g.fillRect(0, 0, getWidth(), getHeight() / 2);
        
        // Draw the sun and apply clipping (sun is clipped within viewport)
        drawSun(g);
        
        // Draw ships
        drawShip(g, 100, getHeight() - 100, 50); // Ship 1
        drawShip(g, 300, getHeight() - 120, 70); // Ship 2
        drawShip(g, 500, getHeight() - 140, 90); // Ship 3
        
        // Draw and move birds with clipping applied
        drawAndMoveBirds(g);
    }

    // Method to draw the sun and apply clipping
    private void drawSun(Graphics g) {
        // Apply clipping to ensure sun stays within the viewport
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setClip(0, 0, getWidth(), getHeight() / 2); // Clip within the sky region

        // Draw the sun
        g2d.setColor(Color.ORANGE);
        g2d.fillOval(sunX, sunY, 80, 80); // Sun's position based on sunX, sunY
        
        g2d.dispose();
    }

    // Method to draw ships
    private void drawShip(Graphics g, int x, int y, int size) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, size * 2, size); // Hull
        g.setColor(Color.BLACK);
        g.fillPolygon(new int[]{x + size / 2, x + size, x + size * 3 / 2}, 
                      new int[]{y, y - size / 2, y}, 3); // Sail
    }

    // Method to draw and move birds
    private void drawAndMoveBirds(Graphics g) {
        // Apply clipping to ensure birds stay within the viewport
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setClip(0, 0, getWidth(), getHeight() / 2); // Clip within the sky region
        
        // Draw each bird and update its position
        for (Bird bird : birds) {
            bird.draw(g2d);
            bird.move();
            
            // If bird goes off-screen, reset its position
            if (bird.x > getWidth() || bird.y > getHeight() / 2) {
                bird.resetPosition(getWidth(), getHeight() / 2);
            }
        }
        
        g2d.dispose();
    }

    // Timer action to move the sun and birds
    @Override
    public void actionPerformed(ActionEvent e) {
        // Move the sun across the sky from left to right (timelapse effect)
        sunX += 5;
        
        // Reset sun position after it sets (off-screen to the right)
        if (sunX > getWidth()) {
            sunX = -80; // Reset sun to start position for new day
        }
        
        // Repaint the scene to update the sun's position and bird movements
        repaint();
    }

    // Main method to run the scene
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sea Scene with Sun and Flying Birds");
        SeaScene seaScene = new SeaScene();
        
        frame.add(seaScene);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

// Helper class to represent a bird
class Bird {
    int x, y, speed;
    Random rand = new Random();

    public Bird(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    // Method to draw a bird (simple arcs)
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawArc(x, y, 20, 10, 0, 180);   // Left wing
        g.drawArc(x + 20, y, 20, 10, 0, 180); // Right wing
    }

    // Method to move the bird
    public void move() {
        x += speed; // Move to the right
        y += rand.nextInt(3) - 1; // Random vertical movement
    }

    // Reset bird's position after it flies out of bounds
    public void resetPosition(int screenWidth, int skyHeight) {
        this.x = -50; // Reset to left side of screen (off-screen)
        this.y = rand.nextInt(skyHeight); // Random height in the sky
        this.speed = rand.nextInt(5) + 1; // Random speed
    }
}*/


/*
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SeaScene extends JPanel implements ActionListener {
    private int sunX = 0;  // Starting X position of the sun (off-screen)
    private int sunY = 50; // Y position of the sun (constant)
    private int brightness = 255; // Initial brightness (full brightness for day)
    private boolean isNight = false; // To track if it is night time

    private Timer timer;
    private Bird[] birds;
    private Ship[] ships;
    private int waveOffset = 0; // Offset for wave animation
    private Color skyColor = new Color(135, 206, 235); // Initial sky color
    private Color seaColor = new Color(30, 144, 255); // Initial sea color

    // Constructor to set up the scene and start the timer
    public SeaScene() {
        setDoubleBuffered(true); // Reduce flickering with double buffering

        timer = new Timer(70, this); // Faster timer for quicker animation
        timer.start();

        // Initialize birds with random positions and speeds
        birds = new Bird[5];
        Random rand = new Random();
        for (int i = 0; i < birds.length; i++) {
            birds[i] = new Bird(rand.nextInt(800), rand.nextInt(200), rand.nextInt(5) + 1);
        }

        // Initialize ships with random positions, sizes, and speeds
        ships = new Ship[3];
        int[] shipSizes = {80, 120, 100}; // Different sizes for ships
        int[] yPositions = {400, 450, 430}; // Alternating Y positions for the ships
        for (int i = 0; i < ships.length; i++) {
            int initialY = yPositions[i]; // Use alternate positions for ships
            ships[i] = new Ship(rand.nextInt(800), initialY, rand.nextInt(3) + 1, shipSizes[i]);
        }
    }

    // Paint method to render the scene
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Adjust brightness and color based on sun's position (simulate time of day)
        updateTimeOfDay();

        // Background color with brightness effect
        g.setColor(skyColor); // Sky with changing color
        g.fillRect(0, 0, getWidth(), getHeight() / 2);

        // Draw the sea with wave effect
        drawSea(g);

        // If it's night, draw moon and stars
        if (isNight) {
            drawMoonAndStars(g);
        } else {
            // Draw the sun and apply clipping (sun is clipped within viewport)
            drawSun(g);
            // Draw birds if it's not night
            drawAndMoveBirds(g);
        }

        // Draw and move ships
        drawAndMoveShips(g);
    }

    // Method to update sky and sea colors based on sun's position
    private void updateTimeOfDay() {
        int screenWidth = getWidth();
        if (sunX < screenWidth / 3) {
            brightness = 255; // Morning (full brightness)
            skyColor = new Color(135, 206, 235); // Light blue sky
            seaColor = new Color(30, 144, 255);  // Bright sea blue
        } else if (sunX < 2 * screenWidth / 3) {
            brightness = 180; // Noon (slight dimming)
            skyColor = new Color(100, 180, 230); // Slightly darker sky
        } else if (sunX < screenWidth) {
            brightness = 100; // Evening (more dimming)
            skyColor = new Color(70, 130, 180); // Evening sky
        } else {
            // Night mode starts only after the sun is completely off-screen
            brightness = 50; // Very dim
            isNight = true;
            skyColor = new Color(10, 10, 50); // Dark navy blue for night
            seaColor = new Color(70, 130, 180); // Lighter blue for night sea
        }
    }

    // Method to draw the sun and apply clipping
    private void drawSun(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setClip(0, 0, getWidth(), getHeight() / 2); // Clip within the sky region

        // Draw the sun
        g2d.setColor(Color.ORANGE);
        g2d.fillOval(sunX, sunY, 80, 80); // Sun's position based on sunX, sunY

        g2d.dispose();
    }

    // Method to draw the moon and stars
    private void drawMoonAndStars(Graphics g) {
        // Draw the moon
        g.setColor(Color.WHITE);
        g.fillOval(getWidth() - 150, 50, 80, 80); // Stationary moon

        // Draw stars (simple white dots)
        Random rand = new Random();
        g.setColor(Color.WHITE);
        for (int i = 0; i < 30; i++) {
            int starX = rand.nextInt(getWidth());
            int starY = rand.nextInt(getHeight() / 2); // Stars only in sky region
            g.fillOval(starX, starY, 5, 5);
        }
    }

    // Method to draw the sea with multiple wave effects
    private void drawSea(Graphics g) {
        int seaHeight = getHeight() / 2;
        int seaY = getHeight() / 2;
        g.setColor(seaColor); // Sea color changes with time
        g.fillRect(0, seaY, getWidth(), seaHeight);

        // Draw waves with a sinusoidal effect (three layers: top, middle, bottom)
        g.setColor(new Color(0, 105, 180, brightness));
        drawWaves(g, seaY + 10, 0.1);  // Top wave
        drawWaves(g, seaY + seaHeight / 3, 0.15);  // Middle wave
        drawWaves(g, seaY + 2 * seaHeight / 3, 0.1);  // Bottom wave
    }

    // Helper method to draw waves at a specific Y position with a specified speed
    private void drawWaves(Graphics g, int waveY, double speed) {
        for (int i = 0; i < getWidth(); i += 20) {
            int waveHeight = (int) (10 * Math.sin((i + waveOffset) * speed)); // Wave effect
            g.fillOval(i, waveY + waveHeight, 40, 20);
        }
    }

    // Method to draw and move ships
    private void drawAndMoveShips(Graphics g) {
        for (Ship ship : ships) {
            ship.draw(g);
            ship.move(getWidth());
        }
    }

    // Method to draw and move birds
    private void drawAndMoveBirds(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setClip(0, 0, getWidth(), getHeight() / 2); // Clip within the sky region

        // Draw each bird and update its position
        for (Bird bird : birds) {
            bird.draw(g2d);
            bird.move();

            // If bird goes off-screen, reset its position
            if (bird.x > getWidth() || bird.y > getHeight() / 2) {
                bird.resetPosition(getWidth(), getHeight() / 2);
            }
        }

        g2d.dispose();
    }

    // Timer action to move the sun, birds, ships, and waves
    @Override
    public void actionPerformed(ActionEvent e) {
        // Move the sun across the sky from left to right (timelapse effect)
        sunX += 3; // Slightly faster sun movement

        // Reset sun position after it sets (off-screen to the right)
        if (sunX > getWidth()) {
            sunX = -80; // Reset sun to start position for new day
            isNight = false; // Switch back to day mode
        }

        // Update wave animation
        waveOffset += 5;

        // Repaint the scene to update the sun, birds, ships, and waves
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600); // Default size
    }

    // Main method to run the scene
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sea Scene with Sun, Moon, Waves, Ships, and Flying Birds");
        SeaScene seaScene = new SeaScene();

        frame.add(seaScene);
        frame.pack(); // Pack the frame to respect preferred sizes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

// Helper class to represent a bird
class Bird {
    int x, y, speed;
    Random rand = new Random();

    public Bird(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    // Method to draw a bird (simple arcs)
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawArc(x, y, 20, 10, 0, 180);   // Left wing
        g.drawArc(x + 20, y, 20, 10, 0, 180); // Right wing
    }

    // Method to move the bird
    public void move() {
        x += speed; // Move to the right
        y += rand.nextInt(3) - 1; // Random vertical movement
    }

    // Reset bird's position after it flies out of bounds
    public void resetPosition(int screenWidth, int skyHeight) {
        this.x = -50; // Reset to left side of screen (off-screen)
        this.y = rand.nextInt(skyHeight); // Random height in the sky
        this.speed = rand.nextInt(5) + 1; // Random speed
    }
}

// Helper class to represent a ship
class Ship {
    int x, y, speed, size;

    public Ship(int x, int y, int speed, int size) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.size = size;
    }

    // Method to draw a ship with varying size
    public void draw(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, size, 30); // Hull with varying size
        g.setColor(Color.BLACK);
        g.fillPolygon(new int[]{x + size / 2 - 10, x + size / 2, x + size / 2 + 10}, 
                      new int[]{y, y - 30, y}, 3); // Sail with adjusted size
    }

    // Method to move the ship
    public void move(int screenWidth) {
        x += speed; // Move to the right

        // Reset ship position if it goes off-screen
        if (x > screenWidth) {
            x = -size; // Reset to left side after moving off-screen
        }
    }
}*/




/*
//new code
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SeaScene extends JPanel implements ActionListener {
    private int sunX = 0;  // Starting X position of the sun (off-screen)
    private int sunY = 50; // Y position of the sun (constant)
    private int brightness = 255; // Initial brightness (full brightness for day)
    private boolean isNight = false; // To track if it is night time

    private Timer timer;
    private Bird[] birds;
    private Ship[] ships;
    private int waveOffset = 0; // Offset for wave animation
    private Color skyColor = new Color(135, 206, 235); // Initial sky color
    private Color seaColor = new Color(30, 144, 255); // Initial sea color

    // Constructor to set up the scene and start the timer
    public SeaScene() {
        setDoubleBuffered(true); // Reduce flickering with double buffering

        timer = new Timer(70, this); // Faster timer for quicker animation
        timer.start();

        // Initialize birds with random positions and speeds
        birds = new Bird[5];
        Random rand = new Random();
        for (int i = 0; i < birds.length; i++) {
            birds[i] = new Bird(rand.nextInt(800), rand.nextInt(200), rand.nextInt(5) + 1);
        }

        // Initialize ships with random positions, sizes, and speeds
        ships = new Ship[3];
        int[] shipSizes = {80, 120, 100}; // Different sizes for ships
        int[] yPositions = {400, 450, 430}; // Alternating Y positions for the ships
        for (int i = 0; i < ships.length; i++) {
            int initialY = yPositions[i]; // Use alternate positions for ships
            ships[i] = new Ship(rand.nextInt(800), initialY, rand.nextInt(3) + 1, shipSizes[i]);
        }
    }

    // Paint method to render the scene
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Adjust brightness and color based on sun's position (simulate time of day)
        updateTimeOfDay();

        // Background color with brightness effect
        g.setColor(skyColor); // Sky with changing color
        g.fillRect(0, 0, getWidth(), getHeight() / 2);

        // Draw the sea with wave effect
        drawSea(g);

        // If it's night, draw moon and stars
        if (isNight || sunX > getWidth()) { // Ensure moon and stars are persistent after sunset
            drawMoonAndStars(g);
        } else {
            // Draw the sun and apply clipping (sun is clipped within viewport)
            drawSun(g);
            // Draw birds if it's not night
            drawAndMoveBirds(g);
        }

        // Draw and move ships
        drawAndMoveShips(g);
    }

    // Method to update sky and sea colors based on sun's position
    private void updateTimeOfDay() {
        int screenWidth = getWidth();
        if (sunX < screenWidth / 3) {
            brightness = 255; // Morning (full brightness)
            skyColor = new Color(135, 206, 235); // Light blue sky
            seaColor = new Color(30, 144, 255);  // Bright sea blue
        } else if (sunX < 2 * screenWidth / 3) {
            brightness = 180; // Noon (slight dimming)
            skyColor = new Color(100, 180, 230); // Slightly darker sky
        } else if (sunX < screenWidth) {
            brightness = 100; // Evening (more dimming)
            skyColor = new Color(70, 130, 180); // Evening sky
        } else {
            // Night mode starts only after the sun is completely off-screen
            brightness = 50; // Very dim
            isNight = true;
            skyColor = new Color(10, 10, 50); // Dark navy blue for night
            seaColor = new Color(70, 130, 180); // Lighter blue for night sea
        }
    }

    // Method to draw the sun and apply clipping
    private void drawSun(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setClip(0, 0, getWidth(), getHeight() / 2); // Clip within the sky region

        // Draw the sun
        g2d.setColor(Color.ORANGE);
        g2d.fillOval(sunX, sunY, 80, 80); // Sun's position based on sunX, sunY

        g2d.dispose();
    }

    // Method to draw the moon and stars
    private void drawMoonAndStars(Graphics g) {
        // Draw the moon
        g.setColor(Color.WHITE);
        g.fillOval(getWidth() - 150, 50, 80, 80); // Stationary moon

        // Draw stars (simple white dots)
        Random rand = new Random();
        g.setColor(Color.WHITE);
        for (int i = 0; i < 30; i++) {
            int starX = rand.nextInt(getWidth());
            int starY = rand.nextInt(getHeight() / 2); // Stars only in sky region
            g.fillOval(starX, starY, 5, 5);
        }
    }

    // Method to draw the sea with multiple wave effects
    private void drawSea(Graphics g) {
        int seaHeight = getHeight() / 2;
        int seaY = getHeight() / 2;
        g.setColor(seaColor); // Sea color changes with time
        g.fillRect(0, seaY, getWidth(), seaHeight);

        // Draw waves with a sinusoidal effect (three layers: top, middle, bottom)
        g.setColor(new Color(0, 105, 180, brightness));
        drawWaves(g, seaY + 10, 0.1);  // Top wave
        drawWaves(g, seaY + seaHeight / 3, 0.15);  // Middle wave
        drawWaves(g, seaY + 2 * seaHeight / 3, 0.1);  // Bottom wave
    }

    // Helper method to draw waves at a specific Y position with a specified speed
    private void drawWaves(Graphics g, int waveY, double speed) {
        for (int i = 0; i < getWidth(); i += 20) {
            int waveHeight = (int) (10 * Math.sin((i + waveOffset) * speed)); // Wave effect
            g.fillOval(i, waveY + waveHeight, 40, 20);
        }
    }

    // Method to draw and move ships
    private void drawAndMoveShips(Graphics g) {
        for (Ship ship : ships) {
            ship.draw(g);
            ship.move(getWidth());
        }
    }

    // Method to draw and move birds
    private void drawAndMoveBirds(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setClip(0, 0, getWidth(), getHeight() / 2); // Clip within the sky region

        // Draw each bird and update its position
        for (Bird bird : birds) {
            bird.draw(g2d);
            bird.move();

            // If bird goes off-screen, reset its position
            if (bird.x > getWidth() || bird.y > getHeight() / 2) {
                bird.resetPosition(getWidth(), getHeight() / 2);
            }
        }

        g2d.dispose();
    }

    // Timer action to move the sun, birds, ships, and waves
    @Override
    public void actionPerformed(ActionEvent e) {
        // Move the sun across the sky from left to right (timelapse effect)
        sunX += 3; // Slightly faster sun movement

        // Reset sun position after it sets (off-screen to the right)
        if (sunX > getWidth()) {
            sunX = -80; // Reset sun to start position for new day
            isNight = false; // Switch back to day mode
        }

        // Update wave animation
        waveOffset += 5;

        // Repaint the scene to update the sun, birds, ships, and waves
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600); // Default size
    }

    // Main method to run the scene
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sea Scene with Sun, Moon, Waves, Ships, and Flying Birds");
        SeaScene seaScene = new SeaScene();

        frame.add(seaScene);
        frame.pack(); // Pack the frame to respect preferred sizes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
*/


import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SeaScene extends JPanel implements ActionListener {
    private int sunX = 0;  // Starting X position of the sun (off-screen)
    private int sunY = 50; // Y position of the sun (constant)
    private int brightness = 255; // Initial brightness (full brightness for day)
    private boolean isNight = false; // To track if it is night time
    private boolean transitionStopped = false; // To stop the transition at night

    private Timer timer;
    private Bird[] birds;
    private Ship[] ships;
    private int waveOffset = 0; // Offset for wave animation
    private Color skyColor = new Color(135, 206, 235); // Initial sky color
    private Color seaColor = new Color(30, 144, 255); // Initial sea color

    // Constructor to set up the scene and start the timer
    public SeaScene() {
        setDoubleBuffered(true); // Reduce flickering with double buffering

        timer = new Timer(70, this); // Faster timer for quicker animation
        timer.start();

        // Initialize birds with random positions and speeds
        birds = new Bird[5];
        Random rand = new Random();
        for (int i = 0; i < birds.length; i++) {
            birds[i] = new Bird(rand.nextInt(800), rand.nextInt(200), rand.nextInt(5) + 1);
        }

        // Initialize ships with random positions, sizes, and speeds
        ships = new Ship[3];
        int[] shipSizes = {80, 120, 100}; // Different sizes for ships
        int[] yPositions = {400, 450, 430}; // Alternating Y positions for the ships
        for (int i = 0; i < ships.length; i++) {
            int initialY = yPositions[i]; // Use alternate positions for ships
            ships[i] = new Ship(rand.nextInt(800), initialY, rand.nextInt(3) + 1, shipSizes[i]);
        }
    }

    // Paint method to render the scene
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Adjust brightness and color based on sun's position (simulate time of day)
        updateTimeOfDay();

        // Background color with brightness effect
        g.setColor(skyColor); // Sky with changing color
        g.fillRect(0, 0, getWidth(), getHeight() / 2);

        // Draw the sea with wave effect
        drawSea(g);

        // If it's night, draw moon and stars
        if (isNight || sunX > getWidth()) { // Ensure moon and stars are persistent after sunset
            drawMoonAndStars(g);
        } else {
            // Draw the sun and apply clipping (sun is clipped within viewport)
            drawSun(g);
            // Draw birds if it's not night
            drawAndMoveBirds(g);
        }

        // Draw and move ships
        drawAndMoveShips(g);
    }

    // Method to update sky and sea colors based on sun's position
    private void updateTimeOfDay() {
        if (transitionStopped) return; // Stop the transition when night mode is active

        int screenWidth = getWidth();
        if (sunX < screenWidth / 3) {
            brightness = 255; // Morning (full brightness)
            skyColor = new Color(135, 206, 235); // Light blue sky
            seaColor = new Color(30, 144, 255);  // Bright sea blue
        } else if (sunX < 2 * screenWidth / 3) {
            brightness = 180; // Noon (slight dimming)
            skyColor = new Color(100, 180, 230); // Slightly darker sky
        } else if (sunX < screenWidth) {
            brightness = 100; // Evening (more dimming)
            skyColor = new Color(70, 130, 180); // Evening sky
        } else {
            // Night mode starts only after the sun is completely off-screen
            brightness = 50; // Very dim
            isNight = true;
            skyColor = new Color(10, 10, 50); // Dark navy blue for night
            seaColor = new Color(70, 130, 180); // Lighter blue for night sea
            transitionStopped = true; // Stop further transition
        }
    }

    // Method to draw the sun and apply clipping
    private void drawSun(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setClip(0, 0, getWidth(), getHeight() / 2); // Clip within the sky region

        // Draw the sun
        g2d.setColor(Color.ORANGE);
        g2d.fillOval(sunX, sunY, 80, 80); // Sun's position based on sunX, sunY

        g2d.dispose();
    }

    // Method to draw the moon and stars
    private void drawMoonAndStars(Graphics g) {
        // Draw the moon
        g.setColor(Color.WHITE);
        g.fillOval(getWidth() - 150, 50, 80, 80); // Stationary moon

        // Draw stars (simple white dots)
        Random rand = new Random();
        g.setColor(Color.WHITE);
        for (int i = 0; i < 30; i++) {
            int starX = rand.nextInt(getWidth());
            int starY = rand.nextInt(getHeight() / 2); // Stars only in sky region
            g.fillOval(starX, starY, 5, 5);
        }
    }

    // Method to draw the sea with multiple wave effects
    private void drawSea(Graphics g) {
        int seaHeight = getHeight() / 2;
        int seaY = getHeight() / 2;
        g.setColor(seaColor); // Sea color changes with time
        g.fillRect(0, seaY, getWidth(), seaHeight);

        // Draw waves with a sinusoidal effect (three layers: top, middle, bottom)
        g.setColor(new Color(0, 105, 180, brightness));
        drawWaves(g, seaY + 10, 0.1);  // Top wave
        drawWaves(g, seaY + seaHeight / 3, 0.15);  // Middle wave
        drawWaves(g, seaY + 2 * seaHeight / 3, 0.1);  // Bottom wave
    }

    // Helper method to draw waves at a specific Y position with a specified speed
    private void drawWaves(Graphics g, int waveY, double speed) {
        for (int i = 0; i < getWidth(); i += 20) {
            int waveHeight = (int) (10 * Math.sin((i + waveOffset) * speed)); // Wave effect
            g.fillOval(i, waveY + waveHeight, 40, 20);
        }
    }

    // Method to draw and move ships
    private void drawAndMoveShips(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setClip(0, 0, getWidth(), getHeight() / 2);
        for (Ship ship : ships) {
            ship.draw(g);
            ship.move(getWidth());
        }
    }

    // Method to draw and move birds
    private void drawAndMoveBirds(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setClip(0, 0, getWidth(), getHeight() / 2); // Clip within the sky region

        // Draw each bird and update its position
        for (Bird bird : birds) {
            bird.draw(g2d);
            bird.move();

            // If bird goes off-screen, reset its position
            if (bird.x > getWidth() || bird.y > getHeight() / 2) {
                bird.resetPosition(getWidth(), getHeight() / 2);
            }
        }

        g2d.dispose();
    }

    // Timer action to move the sun, birds, ships, and waves
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!transitionStopped) { // Stop the transition if in night mode
            // Move the sun across the sky from left to right (timelapse effect)
            sunX += 3; // Slightly faster sun movement
        }

        // Update wave animation
        waveOffset += 5;

        // Repaint the scene to update the sun, birds, ships, and waves
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600); // Default size
    }

    // Main method to run the scene
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sea Scene with Sun, Moon, Waves, Ships, and Flying Birds");
        SeaScene seaScene = new SeaScene();

        frame.add(seaScene);
        frame.pack(); // Pack the frame to respect preferred sizes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}



/*
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SeaScene extends JPanel implements ActionListener {
    private int sunX = 0;  // Starting X position of the sun (off-screen)
    private int sunY = 50; // Y position of the sun (constant)
    private int brightness = 255; // Initial brightness (full brightness for day)
    private boolean isNight = false; // To track if it is night time
    private boolean transitionStopped = false; // To stop the transition at night

    private Timer timer;
    private Bird[] birds;
    private Ship[] ships;
    private int waveOffset = 0; // Offset for wave animation
    private Color skyColor = new Color(135, 206, 235); // Initial sky color
    private Color seaColor = new Color(30, 144, 255); // Initial sea color

    // Star properties
    private Point[] stars; // Array to hold star positions
    private final int numStars = 100; // Number of stars

    // Constructor to set up the scene and start the timer
    public SeaScene() {
        setDoubleBuffered(true); // Reduce flickering with double buffering

        timer = new Timer(70, this); // Faster timer for quicker animation
        timer.start();

        // Initialize birds with random positions and speeds
        birds = new Bird[5];
        Random rand = new Random();
        for (int i = 0; i < birds.length; i++) {
            birds[i] = new Bird(rand.nextInt(800), rand.nextInt(200), rand.nextInt(5) + 1);
        }

        // Initialize ships with random positions, sizes, and speeds
        ships = new Ship[3];
        int[] shipSizes = {80, 120, 100}; // Different sizes for ships
        int[] yPositions = {400, 450, 430}; // Alternating Y positions for the ships
        for (int i = 0; i < ships.length; i++) {
            int initialY = yPositions[i]; // Use alternate positions for ships
            ships[i] = new Ship(rand.nextInt(800), initialY, rand.nextInt(3) + 1, shipSizes[i]);
        }

        // Initialize stars with evenly distributed positions across the sky
        stars = new Point[numStars];
        for (int i = 0; i < numStars; i++) {
            stars[i] = new Point(rand.nextInt(800), rand.nextInt(200)); // Randomly spread in the upper half
        }
    }

    // Paint method to render the scene
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Adjust brightness and color based on sun's position (simulate time of day)
        updateTimeOfDay();

        // Background color with brightness effect
        g.setColor(skyColor); // Sky with changing color
        g.fillRect(0, 0, getWidth(), getHeight() / 2);

        // Draw the sea with wave effect
        drawSea(g);

        // If it's night, draw moon and stars
        if (isNight || sunX > getWidth()) { // Ensure moon and stars are persistent after sunset
            drawMoonAndStars(g);
        } else {
            // Draw the sun and apply clipping (sun is clipped within viewport)
            drawSun(g);
            // Draw birds if it's not night
            drawAndMoveBirds(g);
        }

        // Draw and move ships
        drawAndMoveShips(g);
    }

    // Method to update sky and sea colors based on sun's position
    private void updateTimeOfDay() {
        if (transitionStopped) return; // Stop the transition when night mode is active

        int screenWidth = getWidth();
        if (sunX < screenWidth / 3) {
            brightness = 255; // Morning (full brightness)
            skyColor = new Color(135, 206, 235); // Light blue sky
            seaColor = new Color(30, 144, 255);  // Bright sea blue
        } else if (sunX < 2 * screenWidth / 3) {
            brightness = 180; // Noon (slight dimming)
            skyColor = new Color(100, 180, 230); // Slightly darker sky
        } else if (sunX < screenWidth) {
            brightness = 100; // Evening (more dimming)
            skyColor = new Color(70, 130, 180); // Evening sky
        } else {
            // Night mode starts only after the sun is completely off-screen
            brightness = 50; // Very dim
            isNight = true;
            skyColor = new Color(10, 10, 50); // Dark navy blue for night
            seaColor = new Color(70, 130, 180); // Lighter blue for night sea
            transitionStopped = true; // Stop further transition
        }
    }

    // Method to draw the sun and apply clipping
    private void drawSun(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setClip(0, 0, getWidth(), getHeight() / 2); // Clip within the sky region

        // Draw the sun
        g2d.setColor(Color.ORANGE);
        g2d.fillOval(sunX, sunY, 80, 80); // Sun's position based on sunX, sunY

        g2d.dispose();
    }

    // Method to draw the moon and stars
    private void drawMoonAndStars(Graphics g) {
        // Draw the moon
        g.setColor(Color.WHITE);
        g.fillOval(getWidth() - 150, 50, 80, 80); // Stationary moon

        // Draw stars (stable positions)
        g.setColor(Color.WHITE);
        for (Point star : stars) {
            g.fillOval(star.x, star.y, 5, 5); // Use fixed positions for stars
        }
    }

    // Method to draw the sea with multiple wave effects
    private void drawSea(Graphics g) {
        int seaHeight = getHeight() / 2;
        int seaY = getHeight() / 2;
        g.setColor(seaColor); // Sea color changes with time
        g.fillRect(0, seaY, getWidth(), seaHeight);

        // Draw waves with a sinusoidal effect (three layers: top, middle, bottom)
        g.setColor(new Color(0, 105, 180, brightness));
        drawWaves(g, seaY + 10, 0.1);  // Top wave
        drawWaves(g, seaY + seaHeight / 3, 0.15);  // Middle wave
        drawWaves(g, seaY + 2 * seaHeight / 3, 0.1);  // Bottom wave
    }

    // Helper method to draw waves at a specific Y position with a specified speed
    private void drawWaves(Graphics g, int waveY, double speed) {
        for (int i = 0; i < getWidth(); i += 20) {
            int waveHeight = (int) (10 * Math.sin((i + waveOffset) * speed)); // Wave effect
            g.fillOval(i, waveY + waveHeight, 40, 20);
        }
    }

    // Method to draw and move ships
    private void drawAndMoveShips(Graphics g) {
        for (Ship ship : ships) {
            ship.draw(g);
            ship.move(getWidth());
        }
    }

    // Method to draw and move birds
    private void drawAndMoveBirds(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setClip(0, 0, getWidth(), getHeight() / 2); // Clip within the sky region

        // Draw each bird and update its position
        for (Bird bird : birds) {
            bird.draw(g2d);
            bird.move();

            // If bird goes off-screen, reset its position
            if (bird.x > getWidth() || bird.y > getHeight() / 2) {
                bird.resetPosition(getWidth(), getHeight() / 2);
            }
        }

        g2d.dispose();
    }

    // Timer action to move the sun, birds, ships, and waves
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!transitionStopped) { // Stop the transition if in night mode
            // Move the sun across the sky from left to right (timelapse effect)
            sunX += 3; // Slightly faster sun movement
        }

        // Update wave animation
        waveOffset += 5;

        // Repaint the scene to update the sun, birds, ships, and waves
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600); // Default size
    }

    // Main method to run the scene
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sea Scene with Sun, Moon, Waves, Ships, and Birds");
        SeaScene seaScene = new SeaScene();

        frame.add(seaScene);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

// Helper class to represent a bird
class Bird {
    int x, y, speed;
    Random rand = new Random();

    public Bird(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    // Method to draw a bird (simple arcs)
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawArc(x, y, 20, 10, 0, 180);   // Left wing
        g.drawArc(x + 20, y, 20, 10, 0, 180); // Right wing
    }

    // Method to move the bird
    public void move() {
        x += speed; // Move to the right
        y += rand.nextInt(3) - 1; // Random vertical movement
    }

    // Reset bird's position after it flies out of bounds
    public void resetPosition(int screenWidth, int skyHeight) {
        this.x = -50; // Reset to left side of screen (off-screen)
        this.y = rand.nextInt(skyHeight); // Random height in the sky
        this.speed = rand.nextInt(5) + 1; // Random speed
    }
}

// Helper class to represent a ship
class Ship {
    int x, y, speed, size; // Size is added to allow different ship sizes
    Random rand = new Random();

    public Ship(int x, int y, int speed, int size) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.size = size; // Set size based on the parameter
    }

    // Method to draw a ship
    public void draw(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, size, 30); // Hull with dynamic size
        g.setColor(Color.BLACK);
        g.fillPolygon(new int[]{x + size / 2 - 10, x + size / 2, x + size / 2 + 10}, new int[]{y, y - 30, y}, 3); // Sail
    }

    // Method to move the ship
    public void move(int screenWidth) {
        x += speed; // Move to the right

        // Reset ship position if it goes off-screen
        if (x > screenWidth) {
            x = -size; // Reset to left side after moving off-screen
        }
    }
}
*/