import java.lang.Math;

public class Planet {

    public double xxPos = 0, yyPos = 0, xxVel = 0, yyVel = 0, mass = 0;
    public String imgFileName = "";
    static final double g = 6.67e-11;
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet Planet){
        this.xxPos = Planet.xxPos;
        this.yyPos = Planet.yyPos;
        this.xxVel = Planet.xxVel;
        this.yyVel = Planet.yyVel;
        this.mass = Planet.mass;
        this.imgFileName = Planet.imgFileName;
    }

    public double calcDistance(Planet p2){
        double r2 = Math.pow(this.xxPos - p2.xxPos, 2) + Math.pow(this.yyPos - p2.yyPos, 2);

        return Math.sqrt(r2);    
    }

    public double calcForceExertedBy(Planet p2){
        double r2 = Math.pow(this.xxPos - p2.xxPos, 2) + Math.pow(this.yyPos - p2.yyPos, 2);

        return g * this.mass * p2.mass / r2;
    }

    public double calcForceExertedByX(Planet p2){
        double r2 = Math.pow(this.xxPos - p2.xxPos, 2) + Math.pow(this.yyPos - p2.yyPos, 2);
        double f = g * this.mass * p2.mass / r2;
        
        double bigger = Math.max(this.xxPos, p2.xxPos), smaller = Math.min(this.xxPos, p2.xxPos);
        
        return f * (bigger - smaller) / Math.sqrt(r2);
    }

    public double calcForceExertedByY(Planet p2){
        double r2 = Math.pow(this.xxPos - p2.xxPos, 2) + Math.pow(this.yyPos - p2.yyPos, 2);
        double f = g * this.mass * p2.mass / r2;
        
        double bigger = Math.max(this.yyPos, p2.yyPos), smaller = Math.min(this.yyPos, p2.yyPos);

        return f *(bigger - smaller) / Math.sqrt(r2);
    }

    public void update(double time, double fx, double fy){
        double ax = fx / mass, ay = fy / mass;

        this.xxVel = this.xxVel + time * ax;
        this.yyVel = this.yyVel + time * ay;

        this.xxPos = this.xxPos + time * this.xxVel;
        this.yyPos = this.yyPos + time * this.yyVel;
    }

    public double calcNetForceExertedByX(Planet[] arrayPlanet){
        double sum = 0;

        for(int i = 0; i < arrayPlanet.length; i++){
            if(arrayPlanet[i].xxPos == this.xxPos && arrayPlanet[i].yyPos == this.yyPos){

            }else{
                sum += this.calcForceExertedByX(arrayPlanet[i]);
            }
        }
        return sum;
    }

    public double calcNetForceExertedByY(Planet[] arrayPlanet){
        double sum = 0;

        for(int i = 0; i < arrayPlanet.length; i++){
            Planet a = arrayPlanet[i];
            if(a.xxPos == this.xxPos && a.yyPos == this.yyPos){

            }else{
                sum += this.calcForceExertedByY(a);
            }
        }
        return sum;
    }

    public double CalcNetForceExertedByXY(Planet[] arrayPlanet){
        return 0;
    }

}
