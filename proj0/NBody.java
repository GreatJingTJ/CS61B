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
        if(args.length() == 3){
            double T = Double.parseDouble(args[0]), dt = Double.parseDouble(arhs[1]);
            String filename = args[2];
            double r = this.readRadius(filename);
            Planet [] arrayPlanet = this.readPlanets(filename);
        }
    }


     
}