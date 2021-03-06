/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.flow.demo.minesweeper.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.demo.minesweeper.component.component.MinesweeperComponent;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.server.VaadinService;

/**
 * View which demonstrates how you can use the Flow {@link Component} API to
 * create a Minesweeper game.
 */
@Route("")
@StyleSheet("frontend://minesweeper.css")
public class MinesweeperView extends Div {
    /**
     * Create Minesweeper view.
     */
    public MinesweeperView() {
        VaadinRequest request = VaadinService.getCurrentRequest();

        long seed = getParam(request, "seed", (int) System.currentTimeMillis());
        double mineDensity = getParam(request, "mineDensity", 20) / 100.0;
        int rows = getParam(request, "rows", 10);
        int cols = getParam(request, "cols", 10);

        add(new MinesweeperComponent(seed, mineDensity, rows, cols));
    }

    private static int getParam(VaadinRequest request, String name,
            int defaultValue) {
        int value;
        String colsParam = request.getParameter(name);
        if (colsParam != null) {
            value = Integer.parseInt(colsParam);
        } else {
            value = defaultValue;
        }
        return value;
    }

}
