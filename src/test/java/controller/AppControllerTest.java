package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ventera.TemperatureUnit;
import org.ventera.VolumeUnit;
import org.ventera.controller.AppController;
import org.ventera.service.UnitConverterService;

public class AppControllerTest {

    private AppController appController;

    @BeforeEach
    public void setUp() {
        UnitConverterService unitConverterService = new UnitConverterService();
        this.appController = new AppController(unitConverterService);
    }

    @Test
    public void givenVolumeInputShouldConvert() {
        String ret = appController.convertVolume(VolumeUnit.CUBIC_FEET, VolumeUnit.CUBIC_INCH, 1).getBody();
        assert "1728.0".equals(ret);
    }

    @Test
    public void givenVolumeInputShouldReturnZero() {
        String ret = appController.convertVolume(VolumeUnit.CUBIC_INCH, VolumeUnit.CUBIC_FEET, 0).getBody();
        assert "0.0".equals(ret);
    }

    @Test
    public void givenTemperatureInputShouldConvert() {
        String ret = appController.convertTemperature(TemperatureUnit.CELSIUS, TemperatureUnit.KELVIN, 1).getBody();
        assert "274.15".equals(ret);
    }

    @Test
    public void givenTemperatureShouldReturnSameValue() {
        String ret = appController.convertTemperature(TemperatureUnit.CELSIUS, TemperatureUnit.CELSIUS, 30).getBody();
        assert "30.0".equals(ret);
    }
}
