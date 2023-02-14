package Task1;

public class Laptop {
    private String brand;
    private String model;
    private String gpu;
    private String cpu;
    private String ram;

    public Laptop(String brand, String model, String gpu, String cpu, String ram) {
        this.brand = brand;
        this.model = model;
        this.gpu = gpu;
        this.cpu = cpu;
        this.ram = ram;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getGpu() {
        return gpu;
    }

    public String getCpu() {
        return cpu;
    }

    public String getRam() {
        return ram;
    }

    @Override
    public String toString() {
        return "Brand: " + brand + ", Model: " + model + ", CPU: " + cpu + ", GPU: " + gpu + ", RAM: " + ram;
    }
}