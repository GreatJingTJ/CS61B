public class NBody{
    public static double readRadius(String path){
        if(path.length() != 0){
            In in = new In(path);
            int firstInt = in.readInt();
            double radius = in.readDouble();

            return radius;
        }
        return 0;
    }

    public static Planet [] readPlanets(String path){
        
        Planet [] a = new Planet[0];
        if(path.length() != 0){
            In in = new In(path);
            int firstInt = in.readInt();
            double radius = in.readDouble();

            Planet [] arrayPlanets = new Planet[firstInt];

            for(int i = 0; i < firstInt; i++){
                Planet planet = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
                arrayPlanets[i] = planet;
            }

            return arrayPlanets;
        }
        return a;
    }

    public static void main(String [] args){
        if(args.length == 3){
            double T = Double.parseDouble(args[0]), dt = Double.parseDouble(args[1]);
            String filename = args[2];
            double r = readRadius(filename);
            Planet [] arrayPlanet = readPlanets(filename);

            StdDraw.enableDoubleBuffering();
            
            
            for(int i = 0; i < T; i += dt){
                double [] xForcesArray = new double[arrayPlanet.length], yForecesArray = new double[arrayPlanet.length];
                for(int j = 0; j < arrayPlanet.length; j++){
                    xForcesArray[j] = arrayPlanet[j].calcNetForceExertedByX(arrayPlanet);
                    yForecesArray[j] = arrayPlanet[j].calcNetForceExertedByY(arrayPlanet);
                }

                for(int j = 0; j < arrayPlanet.length; j++){
                    arrayPlanet[j].update(i, xForcesArray[j], yForecesArray[j]);
                }

                for(Planet planet : arrayPlanet){
                    StdDraw.setScale(-r, r);
                    String backgroundimg = "images/starfield.jpg";
                    StdDraw.clear();
                    StdDraw.picture(0, 0, backgroundimg);
                    planet.draw();
                    StdDraw.show();
                    
                    StdDraw.pause(10);
                }

            }
        }
    }


     
}