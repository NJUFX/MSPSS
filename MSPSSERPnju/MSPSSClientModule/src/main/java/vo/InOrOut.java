package VO;

public enum InOrOut {
  IN,
  OUT;

    @Override
    public String toString() {
        switch (this){
            case IN: return "入库";
            case OUT: return "出库";
            default:
                return "";
        }

    }
}
