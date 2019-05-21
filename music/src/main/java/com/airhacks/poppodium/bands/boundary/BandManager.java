
package com.airhacks.poppodium.bands.boundary;

import com.airhacks.poppodium.bands.entity.Band;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.annotation.RegistryType;

/**
 *
 * @author airhacks.com
 */
@ApplicationScoped
public class BandManager {

    List<Band> bands;

    @Inject
    @RegistryType(type = MetricRegistry.Type.APPLICATION)
    MetricRegistry registry;

    @Inject
    @ConfigProperty(name = "defaultBand", defaultValue = "goldenearing")
    String defaultBand;


    @PostConstruct
    public void init() {
        this.bands = new ArrayList<>();
        this.bands.add(new Band("fear factory", 10));
        this.bands.add(new Band("ramstein", 90));
        this.bands.add(new Band("edgar", -1));
        this.bands.add(new Band(defaultBand, 99));
    }

    @Fallback(fallbackMethod = "silence")
    @Retry(maxRetries = 2)
    public List<Band> getBands() {
        System.out.println("retrying");
        throw new IllegalStateException("no db today");
        //return bands;
    }

    public List<Band> silence() {
        return null;
    }


    public void save(Band band) {
        if (band.loudness > 100) {
            registry.counter("louder_than_goldenearing").inc();
            System.out.println("band rejected, no one is louder= " + band);
            throw new GoldenAreTheLoudestException("Only normaal can be louder");
        } else {
            registry.counter("created_bands").inc();
        }
        System.out.println("band = " + band);
    }

}
