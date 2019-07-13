public class Body {
    
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;
    public static final double g = 6.67e-11;

    // constructors
    public Body(double xP, double yP, double xV,
              double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b) {
        double dx = b.xxPos - xxPos;
        double dy = b.yyPos - yyPos;

        return Math.sqrt(dx*dx + dy*dy);
    }

    public double calcForceExertedBy(Body b) {
        return g * b.mass * mass / (this.calcDistance(b)*this.calcDistance(b));
    }

    public double calcForceExertedByX (Body b) {
        return this.calcForceExertedBy(b) * (b.xxPos - xxPos) / this.calcDistance(b);
    }

    public double calcForceExertedByY (Body b) {
        return this.calcForceExertedBy(b) * (b.yyPos - yyPos) / this.calcDistance(b);

    }

    public double calcNetForceExertedByX (Body[] bodies) {
        double netForceX = 0.0;
        for (Body b : bodies) {
            if (!this.equals(b)) {
                netForceX += calcForceExertedByX(b);
            }
        }
        return netForceX;
    }

    public double calcNetForceExertedByY (Body[] bodies) {
        double netForceY = 0.0;
        for (Body b : bodies) {
            if (!this.equals(b)) {
                netForceY += calcForceExertedByY(b);
            }
        }
        return netForceY;
    }

    public void update(double dt, double fX, double fY) {
        double ax = fX / mass;
        double ay = fY / mass;
        xxVel += dt * ax;
        yyVel += dt * ay;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}












