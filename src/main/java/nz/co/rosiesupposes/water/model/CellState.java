package nz.co.rosiesupposes.water.model;

public record CellState(boolean containsWater, boolean containsPipe) {
    public boolean hasStateChanged(CellState newState) {
        return this.containsPipe != newState.containsPipe
                || this.containsWater != newState.containsWater;
    }
}
