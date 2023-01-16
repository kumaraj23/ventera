package org.ventera.service;

import org.springframework.stereotype.Service;
import org.ventera.TemperatureUnit;
import org.ventera.VolumeUnit;

@Service
public class UnitConverterService {
    
    private static final double ZERO = 0d;

    public double convertVolume(VolumeUnit inputUnit,
                         VolumeUnit targetUnit,
                         double value) {
        switch (inputUnit) {
            case CUBIC_FEET: return handleCubicFeet(targetUnit, value);
            case CUBIC_INCH: return handleCubicInch(targetUnit, value);
            case CUP: return handleCup(targetUnit, value);
            case GALLON: return handleGallon(targetUnit, value);
            case LITER: return handleLiter(targetUnit, value);
            case TABLE_SPOON: return handleTableSpoon(targetUnit, value);
            default: return ZERO;
        }
    }

    public double convertTemperature(TemperatureUnit inputUnit,
                                     TemperatureUnit targetUnit,
                                     double value) {
        switch (inputUnit) {
            case CELSIUS: return handleCelsius(targetUnit, value);
            case FAHRENHEIT: return handleFahrenheit(targetUnit, value);
            case KELVIN: return handleKelvin(targetUnit, value);
            case RANKINE: return handleRankine(targetUnit, value);
            default: return ZERO;
        }
    }

    private double handleCubicFeet(VolumeUnit targetUnit, double value) {
        switch (targetUnit) {
            case CUBIC_FEET: return value;
            case CUBIC_INCH: return value * 1728;
            case CUP: return value * 119.688;
            case GALLON: return value * 7.48;
            case LITER: return value * 28.317;
            case TABLE_SPOON: return value * 0.000522;
            default: return ZERO;
        }
    }

    private double handleCubicInch(VolumeUnit targetUnit, double value) {
        switch (targetUnit) {
            case CUBIC_FEET: return value / 1728;
            case CUBIC_INCH: return value;
            case CUP: return value * 0.069264;
            case GALLON: return value / 231;
            case LITER: return value * 0.016387064;
            case TABLE_SPOON: return value * 3.324675;
            default: return ZERO;
        }
    }

    private double handleCup(VolumeUnit targetUnit, double value) {
        switch (targetUnit) {
            case CUBIC_FEET: return value * 0.008355;
            case CUBIC_INCH: return value * 14.4375;
            case CUP: return value * 0.069264;
            case GALLON: return value / 16;
            case LITER: return value / 4.227;
            case TABLE_SPOON: return value * 16;
            default: return ZERO;
        }
    }

    private double handleGallon(VolumeUnit targetUnit, double value) {
        switch (targetUnit) {
            case CUBIC_FEET: return value / 7.48;
            case CUBIC_INCH: return value * 231;
            case CUP: return value * 16;
            case GALLON: return value;
            case LITER: return value * 3.785412;
            case TABLE_SPOON: return value * 256;
            default: return ZERO;
        }
    }

    private double handleLiter(VolumeUnit targetUnit, double value) {
        switch (targetUnit) {
            case CUBIC_FEET: return value / 28.317;
            case CUBIC_INCH: return value * 61.023744;
            case CUP: return value * 4.22675;
            case GALLON: return value * 0.264172;
            case LITER: return value;
            case TABLE_SPOON: return value * 67.628045;
            default: return ZERO;
        }
    }

    private double handleTableSpoon(VolumeUnit targetUnit, double value) {
        switch (targetUnit) {
            case CUBIC_FEET: return value / 0.000522;
            case CUBIC_INCH: return value / 3.324675;
            case CUP: return value / 16;
            case GALLON: return value / 256;
            case LITER: return value / 67.628045;
            case TABLE_SPOON: return value;
            default: return ZERO;
        }
    }

    private double handleCelsius(TemperatureUnit targetUnit, double value) {
        switch (targetUnit) {
            case CELSIUS: return value;
            case FAHRENHEIT: return (value * 1.8) + 32;
            case KELVIN: return value + 273.15;
            case RANKINE: return (value * 1.8) + 491.67;
            default: return ZERO;
        }
    }

    private double handleFahrenheit(TemperatureUnit targetUnit, double value) {
        switch (targetUnit) {
            case CELSIUS: return ((value - 32) * 5) / 9;
            case FAHRENHEIT: return value;
            case KELVIN: return ((value - 32) * 1.8) + 273.15;
            case RANKINE: return value + 459.67;
            default: return ZERO;
        }
    }

    private double handleKelvin(TemperatureUnit targetUnit, double value) {
        switch (targetUnit) {
            case CELSIUS: return value - 273.15;
            case FAHRENHEIT: return ((value - 273.15) * 1.8) + 32;
            case KELVIN: return value;
            case RANKINE: return value * 1.8;
            default: return ZERO;
        }
    }

    private double handleRankine(TemperatureUnit targetUnit, double value) {
        switch (targetUnit) {
            case CELSIUS: return (value - 491.67) / 1.8;
            case FAHRENHEIT: return value - 459.67;
            case KELVIN: return value / 1.8;
            case RANKINE: return value;
            default: return ZERO;
        }
    }
}
