package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ventera.TemperatureUnit;
import org.ventera.VolumeUnit;
import org.ventera.service.UnitConverterService;

public class UnitConverterServiceTest {

    private UnitConverterService unitConverterService;

    @BeforeEach
    public void setUp() {
        unitConverterService = new UnitConverterService();
    }

    @Test
    public void givenVolumeInputShouldConvert() {
        double ret = unitConverterService.convertVolume(VolumeUnit.CUBIC_FEET, VolumeUnit.CUBIC_INCH, 1d);
        assert 1728.0 == ret;
    }

    @Test
    public void givenVolumeInputShouldReturnZero() {
        double ret = unitConverterService.convertVolume(VolumeUnit.CUBIC_INCH, VolumeUnit.CUBIC_FEET, 0d);
        assert 0.0 == ret;
    }

    @Test
    public void givenTemperatureInputShouldConvert() {
        double ret = unitConverterService.convertTemperature(TemperatureUnit.CELSIUS, TemperatureUnit.KELVIN, 1d);
        assert 274.15 == ret;
    }

    @Test
    public void givenTemperatureShouldReturnSameValue() {
        double ret = unitConverterService.convertTemperature(TemperatureUnit.CELSIUS, TemperatureUnit.CELSIUS, 30d);
        assert 30.0 == ret;
    }
}
