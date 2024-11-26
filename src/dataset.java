public class dataset {
    public double[] X;
    public double[] y;

    public int n;
    int potencia =3;


    public  double[] C;//para las predicciones


    public dataset(){
        this.X= new double[]{1,2,3,4,5,6,7,8,9 };
        this.y= new double[]{3,6,9,12,15,18,21,24,27};
        this.C= new double[] { 66, 70, 62, 33, 55};
        this.n = X.length;

    }

}
