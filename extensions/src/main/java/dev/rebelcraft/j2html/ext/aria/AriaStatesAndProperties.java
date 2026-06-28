package dev.rebelcraft.j2html.ext.aria;

import j2html.attributes.Attribute;

/**
 * https://developer.mozilla.org/en-US/docs/Web/Accessibility/ARIA/ARIA_Techniques
 * <p>
 * Using ARIA: Roles, states, and properties
 * <p>
 * ARIA defines semantics that can be applied to elements, with these divided into roles (defining a type of user interface element) and states and properties that are supported by a role. Authors must assign an ARIA role and the appropriate states and properties to an element during its life-cycle, unless the element already has appropriate ARIA semantics (via use of an appropriate HTML element). Addition of ARIA semantics only exposes extra information to a browser's accessibility API, and does not affect a page's DOM.
 */
public class AriaStatesAndProperties {

    // States and properties

    // Widget attributes

    public static final String aria_autocomplete = "aria-autocomplete";
    public static final String aria_checked = "aria-checked";
    public static final String aria_current = "aria-current";
    public static final String aria_disabled = "aria-disabled";
    public static final String aria_errormessage = "aria-errormessage";
    public static final String aria_expanded = "aria-expanded";
    public static final String aria_haspopup = "aria-haspopup";
    public static final String aria_hidden = "aria-hidden";
    public static final String aria_invalid = "aria-invalid";
    public static final String aria_label = "aria-label";
    public static final String aria_level = "aria-level";
    public static final String aria_modal = "aria-modal";
    public static final String aria_multiline = "aria-multiline";
    public static final String aria_multiselectable = "aria-multiselectable";
    public static final String aria_orientation = "aria-orientation";
    public static final String aria_placeholder = "aria-placeholder";
    public static final String aria_pressed = "aria-pressed";
    public static final String aria_readonly = "aria-readonly";
    public static final String aria_required = "aria-required";
    public static final String aria_selected = "aria-selected";
    public static final String aria_sort = "aria-sort";
    public static final String aria_valuemax = "aria-valuemax";
    public static final String aria_valuemin = "aria-valuemin";
    public static final String aria_valuenow = "aria-valuenow";
    public static final String aria_valuetext = "aria-valuetext";

    // Live region attributes

    public static final String aria_live = "aria-live";
    public static final String aria_relevant = "aria-relevant";
    public static final String aria_atomic = "aria-atomic";
    public static final String aria_busy = "aria-busy";

    // Drag & drop attributes

    public static final String aria_dropeffect = "aria-dropeffect"; // Deprecated
    public static final String aria_grabbed = "aria-grabbed"; // Deprecated

    // Relationship attributes

    public static final String aria_activedescendant = "aria-activedescendant";
    public static final String aria_colcount = "aria-colcount";
    public static final String aria_colindex = "aria-colindex";
    public static final String aria_colspan = "aria-colspan";
    public static final String aria_controls = "aria-controls";
    public static final String aria_describedby = "aria-describedby";
    public static final String aria_details = "aria-details";
    public static final String aria_flowto = "aria-flowto";
    public static final String aria_labelledby = "aria-labelledby";
    public static final String aria_owns = "aria-owns";
    public static final String aria_posinset = "aria-posinset";
    public static final String aria_rowcount = "aria-rowcount";
    public static final String aria_rowindex = "aria-rowindex";
    public static final String aria_rowspan = "aria-rowspan";
    public static final String aria_setsize = "aria-setsize";



    // States and properties

    // Widget attributes

    public static Attribute ariaAutocomplete(String value) { return  new Attribute("aria-autocomplete", value ); }
    public static Attribute ariaChecked(String value) { return  new Attribute("aria-checked", value ); }
    public static Attribute ariaCurrent(String value) { return  new Attribute("aria-current", value ); }
    public static Attribute ariaDisabled(String value) { return  new Attribute("aria-disabled", value ); }
    public static Attribute ariaErrormessage(String value) { return  new Attribute("aria-errormessage", value ); }
    public static Attribute ariaExpanded(String value) { return  new Attribute("aria-expanded", value ); }
    public static Attribute ariaHaspopup(String value) { return  new Attribute("aria-haspopup", value ); }
    public static Attribute ariaHidden(String value) { return  new Attribute("aria-hidden", value ); }
    public static Attribute ariaInvalid(String value) { return  new Attribute("aria-invalid", value ); }
    public static Attribute ariaLabel(String value) { return  new Attribute("aria-label", value ); }
    public static Attribute ariaLevel(String value) { return  new Attribute("aria-level", value ); }
    public static Attribute ariaModal(String value) { return  new Attribute("aria-modal", value ); }
    public static Attribute ariaMultiline(String value) { return  new Attribute("aria-multiline", value ); }
    public static Attribute ariaMultiselectable(String value) { return  new Attribute("aria-multiselectable", value ); }
    public static Attribute ariaOrientation(String value) { return  new Attribute("aria-orientation", value ); }
    public static Attribute ariaPlaceholder(String value) { return  new Attribute("aria-placeholder", value ); }
    public static Attribute ariaPressed(String value) { return  new Attribute("aria-pressed", value ); }
    public static Attribute ariaReadonly(String value) { return  new Attribute("aria-readonly", value ); }
    public static Attribute ariaRequired(String value) { return  new Attribute("aria-required", value ); }
    public static Attribute ariaSelected(String value) { return  new Attribute("aria-selected", value ); }
    public static Attribute ariaSort(String value) { return  new Attribute("aria-sort", value ); }
    public static Attribute ariaValuemax(String value) { return  new Attribute("aria-valuemax", value ); }
    public static Attribute ariaValuemin(String value) { return  new Attribute("aria-valuemin", value ); }
    public static Attribute ariaValuenow(String value) { return  new Attribute("aria-valuenow", value ); }
    public static Attribute ariaValuetext(String value) { return  new Attribute("aria-valuetext", value ); }

    // Live region attributes

    public static Attribute ariaLive(String value) { return  new Attribute("aria-live", value ); }
    public static Attribute ariaRelevant(String value) { return  new Attribute("aria-relevant", value ); }
    public static Attribute ariaAtomic(String value) { return  new Attribute("aria-atomic", value ); }
    public static Attribute ariaBusy(String value) { return  new Attribute("aria-busy", value ); }

    // Drag & drop attributes

    public static Attribute ariaDropeffect(String value) { return  new Attribute("aria-dropeffect", value ); } // Deprecated
    public static Attribute ariaGrabbed(String value) { return  new Attribute("aria-grabbed", value ); } // Deprecated

    // Relationship attributes

    public static Attribute ariaActivedescendant(String value) { return  new Attribute("aria-activedescendant", value ); }
    public static Attribute ariaColcount(String value) { return  new Attribute("aria-colcount", value ); }
    public static Attribute ariaColindex(String value) { return  new Attribute("aria-colindex", value ); }
    public static Attribute ariaColspan(String value) { return  new Attribute("aria-colspan", value ); }
    public static Attribute ariaControls(String value) { return  new Attribute("aria-controls", value ); }
    public static Attribute ariaDescribedby(String value) { return  new Attribute("aria-describedby", value ); }
    public static Attribute ariaDetails(String value) { return  new Attribute("aria-details", value ); }
    public static Attribute ariaFlowto(String value) { return  new Attribute("aria-flowto", value ); }
    public static Attribute ariaLabelledby(String value) { return  new Attribute("aria-labelledby", value ); }
    public static Attribute ariaOwns(String value) { return  new Attribute("aria-owns", value ); }
    public static Attribute ariaPosinset(String value) { return  new Attribute("aria-posinset", value ); }
    public static Attribute ariaRowcount(String value) { return  new Attribute("aria-rowcount", value ); }
    public static Attribute ariaRowindex(String value) { return  new Attribute("aria-rowindex", value ); }
    public static Attribute ariaRowspan(String value) { return  new Attribute("aria-rowspan", value ); }
    public static Attribute ariaSetsize(String value) { return  new Attribute("aria-setsize", value ); }

}
