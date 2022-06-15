package structures;

public class GasCar extends ACar { 
        private float engDis;
        
        public GasCar(String brand, String model, float engDis, int powEngine, int price) {
            super(brand, model, powEngine, price);
            this.engDis = engDis;
        }
        
        @Override
        public String toString() {
            
            String middle =  String.format("%.1fL, %dKW", getEngDis(), getPowEngine());
            return String.format("%s %s", Constants.GAS_CAR, printCarStrBuilder(middle));
            
        }

        public float getEngDis() {
            return engDis;
        }

        public void setEngDis(float engDis) {
            this.engDis = engDis;
        }
        
        

}
 
