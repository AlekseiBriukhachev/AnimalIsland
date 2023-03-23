package com.aleksei.animalisland.utils.view;

import com.aleksei.animalisland.utils.view.DrawableLocation;
import com.aleksei.animalisland.utils.view.CellDrawer;
import com.aleksei.animalisland.utils.view.Drawer;

import static com.aleksei.animalisland.utils.view.ColorUtils.between;

import java.awt.*;


public class HighlightedCellDrawer implements Drawer<DrawableLocation> {

    private final CellDrawer cellDrawer;
    private final Color HIGHLIGHT_BETTER = new Color(0x358F2B);
    private final Color HIGHLIGHT_WORSE = Color.RED;

    public HighlightedCellDrawer(CellDrawer cellDrawer) {
        this.cellDrawer = cellDrawer;
    }

    @Override
    public void draw(DrawableLocation drawableLocation, Graphics2D g2d) {
        cellDrawer.draw(drawableLocation.getLocation(), g2d);

        g2d.setColor(between(HIGHLIGHT_WORSE, HIGHLIGHT_BETTER, drawableLocation.getValue()));
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRect(1, 1, CellDrawer.SIZE - 4, CellDrawer.SIZE - 4);
    }
}
