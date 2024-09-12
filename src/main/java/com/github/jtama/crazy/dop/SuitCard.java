package com.github.jtama.crazy.dop;

public final class SuitCard implements PlayingCard {
    private Color color;
    private Integer index;
    private Face face;

    public Face face(){
        return face;
    }

    public Color color() {
        return color;
    }

    @Override
    public Integer index() {
        if(this.face != null){
            return face.index();
        }
        return index;
    }
}
