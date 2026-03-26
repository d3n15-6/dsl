package com.dslengine.commandprocessor;

import javafx.scene.layout.Region;

public class UnitParser {
    public static double parseDimension(String token, double parentSizeHint) {
        token = token.trim().toLowerCase();

        if (token.equals("auto")) return Region.USE_COMPUTED_SIZE;
        if (token.equals("infinito")) return Double.MAX_VALUE;
        if (token.endsWith("px")) {
            return Double.parseDouble(token.replace("px", "").trim());
        }
        if (token.endsWith("%")) {
            double percent =Double.parseDouble(token.replace("%", "").trim());
            return parentSizeHint * percent;
        }
        return Double.parseDouble(token); // valor absoluto sin unidad.
    }
}
