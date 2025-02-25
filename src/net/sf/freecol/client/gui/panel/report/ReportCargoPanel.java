/**
 *  Copyright (C) 2002-2022   The FreeCol Team
 *
 *  This file is part of FreeCol.
 *
 *  FreeCol is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  FreeCol is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with FreeCol.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.freecol.client.gui.panel.report;

import net.sf.freecol.client.FreeColClient;
import net.sf.freecol.common.model.AbstractUnit;
import net.sf.freecol.common.model.Role;
import net.sf.freecol.common.model.Specification;
import net.sf.freecol.common.model.Unit;
import net.sf.freecol.common.model.UnitType;


/**
 * This panel displays the Cargo Report.
 */
public final class ReportCargoPanel extends ReportUnitPanel {

    /**
     * Creates a cargo report.
     *
     * @param freeColClient The {@code FreeColClient} for the game.
     */
    public ReportCargoPanel(FreeColClient freeColClient) {
        super(freeColClient, "reportCargoAction", false);
    }


    /**
     * {@inheritDoc}
     */
    protected boolean isReportable(Unit unit) {
        return unit.isCarrier();
    }

    /**
     * {@inheritDoc}
     */
    protected boolean isReportable(UnitType unitType, Role role) {
        return unitType.isAvailableTo(getMyPlayer())
            && (unitType.canCarryUnits() || unitType.canCarryGoods())
            && Specification.DEFAULT_ROLE_ID.equals(role.getId());
    }
        
    /**
     * {@inheritDoc}
     */
    protected boolean isReportableREF(AbstractUnit au) {
        return false;
    }
}
