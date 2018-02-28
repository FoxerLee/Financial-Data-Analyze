CREATE TRIGGER TR_RealTime
AFTER UPDATE ON data_real_time
FOR EACH ROW
  BEGIN
    IF NEW.open_value <> OLD.open_value THEN
      UPDATE data_days
      SET open_value = NEW.open_value
      WHERE NEW.id = id;
    END IF;

    IF NEW.close_value <> OLD.close_value AND new.trading_day > '15:28:00'THEN
      UPDATE data_days
        SET close_value = NEW.close_value
      WHERE NEW.id = id;
    END IF;

    IF NEW.high_value <> OLD.high_value THEN
      UPDATE data_days
        SET high_value = NEW.high_value
      WHERE NEW.id = id;
      UPDATE data_weeks
        SET high_value = NEW.high_value
      WHERE NEW.id = id;
      UPDATE data_months
        SET high_value = NEW.high_value
      WHERE NEW.id = id;
    END IF;

    IF NEW.low_value <> OLD.low_value THEN
      UPDATE data_days
        SET low_value = NEW.low_value
      WHERE NEW.id = id;
      UPDATE data_weeks
        SET low_value = NEW.low_value
      WHERE NEW.id = id;
      UPDATE data_months
        SET low_value = NEW.low_value
      WHERE NEW.id = id;
    END IF;
  END;
