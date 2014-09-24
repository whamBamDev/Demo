/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package me.ineson.demo.service.rest;

import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import me.ineson.demo.service.SolarBodyLink;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * @author peter
 *
 */
public class SolarBodyLinkRestClient extends AbstractRestService<SolarBodyLink>{
    
    private static final Logger log = LoggerFactory.getLogger(SolarBodyLinkRestClient.class);
    
    private final static String ENDPOINT_PATH = "solarBodies";

    private final static String LINKS_PATH = "links";

    public SolarBodyLinkRestClient() {
        super( SolarBodyLink.class, new GenericType<List<SolarBodyLink>>() {});
    }
    
    public SolarBodyLinkRestClient(MediaType mediaType) {
        super( SolarBodyLink.class, new GenericType<List<SolarBodyLink>>() {}, mediaType);
    }

    /**
     * Returns all the links for a solar body.
     * @param baseUrl
     * @param solarBodyId
     * @return List of links.
     */
    public List<SolarBodyLink> findBySolarBody(String baseUrl, Long solarBodyId) {
        Assert.notNull(baseUrl, "baseUrl was NULL or empty");
        Assert.notNull(solarBodyId, "Solar body id was NULL");
        log.debug("Calling {} for solar body id {}", baseUrl, solarBodyId);

        String url = baseUrl + "/" + ENDPOINT_PATH + "/" + solarBodyId.toString() + "/" + LINKS_PATH;

        return findMany(url, null, null);
    }

}
