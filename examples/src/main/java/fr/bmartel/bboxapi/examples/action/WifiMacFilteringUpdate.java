/**
 * The MIT License (MIT)
 * <p/>
 * Copyright (c) 2017 Bertrand Martel
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package fr.bmartel.bboxapi.examples.action;

import fr.bmartel.bboxapi.BboxApi;
import fr.bmartel.bboxapi.examples.utils.ExampleUtils;
import fr.bmartel.bboxapi.model.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Update Wifi MAC filtering rule.
 *
 * @author Bertrand Martel
 */
public class WifiMacFilteringUpdate {

    private final static Logger LOGGER = LogManager.getLogger(WifiMacFilteringUpdate.class.getName());

    public static void main(String[] args) {

        BboxApi api = new BboxApi();

        String pass = ExampleUtils.getPassword();

        api.setPassword(pass);

        HttpStatus status = api.updateWifiMacFilterRule(1, true, "12:34:56:78:90:12", "");

        if (status == HttpStatus.OK) {
            LOGGER.debug("filter updated successfully");
        } else {
            LOGGER.debug("failed to update filter, status : " + status);
        }
    }
}