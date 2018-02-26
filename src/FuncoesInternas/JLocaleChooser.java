package FuncoesInternas;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class JLocaleChooser extends JComboBox implements ItemListener {
	private static final long serialVersionUID = 8152430789764877431L;
	protected JComponent component;
        
	public JLocaleChooser() {
	    this(null);
	}
        
    public String getName() {
        return "JLocaleChoose";
    }

	/**
	 * Default JLocaleChooser constructor.
	 */
	public JLocaleChooser(JComponent component) {
		super();
		this.component = component;
		addItemListener(this);
		locales = Calendar.getAvailableLocales();
		localeCount = locales.length;

		for (int i = 0; i < localeCount; i++) {
			if (locales[i].getCountry().length() > 0) {
				addItem(locales[i].getDisplayName());
			}
		}
                
		setLocale(Locale.getDefault());
	}
        
	public void itemStateChanged(ItemEvent iEvt) {
		String item = (String) iEvt.getItem();
		int i;

		for (i = 0; i < localeCount; i++) {
			if (locales[i].getDisplayName().equals(item))
				break;
		}
		setLocale(locales[i], false);
	}
        
	private void setLocale(Locale l, boolean select) {
		Locale oldLocale = locale;
		locale = l;
		int n = 0;

		if (select) {
			for (int i = 0; i < localeCount; i++) {
				if (locales[i].getCountry().length() > 0) {
					if (locales[i].equals(locale))
						setSelectedIndex(n);
					n += 1;
				}
			}
		}

		firePropertyChange("locale", oldLocale, locale);
		if(component != null) {
		    component.setLocale(l);
		}
	}

	/**
	 * Sets the locale. This is a bound property.
	 * 
	 * @see #getLocale
	 */
	public void setLocale(Locale l) {
		setLocale(l, true);
	}

	/**
	 * Returns the locale.
	 */
	public Locale getLocale() {
		return locale;
	}

	private Locale[] locales;
	private Locale locale;
	private int localeCount;
}

