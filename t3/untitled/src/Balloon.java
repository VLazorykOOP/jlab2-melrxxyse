public class Balloon {
    private int x;
    private int y;
    private int radius;

    public Balloon(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public double getIntersectionVolume(Balloon other) {
        double distance = Math.sqrt(Math.pow(other.x - x, 2) + Math.pow(other.y - y, 2));

        if (distance >= radius + other.radius) {
            // No intersection, volumes do not overlap
            return 0;
        } else if (distance + radius <= other.radius) {
            // This balloon is completely inside the other balloon
            return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        } else if (distance + other.radius <= radius) {
            // The other balloon is completely inside this balloon
            return (4.0 / 3.0) * Math.PI * Math.pow(other.radius, 3);
        } else {
            // Partial overlap, calculate the intersection volume
            double h1 = radius - (Math.pow(radius, 2) - Math.pow(other.radius, 2) + Math.pow(distance, 2)) / (2 * distance);
            double h2 = other.radius - (Math.pow(other.radius, 2) - Math.pow(radius, 2) + Math.pow(distance, 2)) / (2 * distance);

            double volume1 = (1.0 / 3.0) * Math.PI * Math.pow(h1, 2) * (3 * radius - h1);
            double volume2 = (1.0 / 3.0) * Math.PI * Math.pow(h2, 2) * (3 * other.radius - h2);

            return volume1 + volume2;
        }
    }

    public double getUnionVolume(Balloon other) {
        double distance = Math.sqrt(Math.pow(other.x - x, 2) + Math.pow(other.y - y, 2));

        if (distance >= radius + other.radius) {
            // No intersection, volumes do not overlap
            return (4.0 / 3.0) * Math.PI * (Math.pow(radius, 3) + Math.pow(other.radius, 3));
        } else if (distance + radius <= other.radius) {
            // This balloon is completely inside the other balloon
            return (4.0 / 3.0) * Math.PI * Math.pow(other.radius, 3);
        } else if (distance + other.radius <= radius) {
            // The other balloon is completely inside this balloon
            return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        } else {
            // Partial overlap, calculate the union volume
            double h1 = radius - (Math.pow(radius, 2) - Math.pow(other.radius, 2) + Math.pow(distance, 2)) / (2 * distance);
            double h2 = other.radius - (Math.pow(other.radius, 2) - Math.pow(radius, 2) + Math.pow(distance, 2)) / (2 * distance);

            double volume1 = (1.0 / 3.0) * Math.PI * Math.pow(h1, 2) * (3 * radius - h1);
            double volume2 = (1.0 / 3.0) * Math.PI * Math.pow(h2, 2) * (3 * other.radius - h2);

            return volume1 + volume2;
        }
    }

    @Override
    public String toString() {
        return "Balloon: center(" + x + ", " + y + "), radius = " + radius;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Balloon other = (Balloon) obj;
        return this.x == other.x && this.y == other.y && this.radius == other.radius;
    }

    public static void main(String[] args) {
        int x1 = Integer.parseInt(args[0]);
        int y1 = Integer.parseInt(args[1]);
        int radius1 = Integer.parseInt(args[2]);

        int x2 = Integer.parseInt(args[3]);
        int y2 = Integer.parseInt(args[4]);
        int radius2 = Integer.parseInt(args[5]);

        Balloon balloon1 = new Balloon(x1, y1, radius1);
        Balloon balloon2 = new Balloon(x2, y2, radius2);

        System.out.println("Balloon 1: " + balloon1);
        System.out.println("Balloon 2: " + balloon2);

        double intersectionVolume = balloon1.getIntersectionVolume(balloon2);
        System.out.println("Intersection Volume: " + intersectionVolume);

        double unionVolume = balloon1.getUnionVolume(balloon2);
        System.out.println("Union Volume: " + unionVolume);
    }
}
