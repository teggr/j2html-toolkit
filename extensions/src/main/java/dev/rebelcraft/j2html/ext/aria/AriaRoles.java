package dev.rebelcraft.j2html.ext.aria;

import j2html.attributes.Attribute;

/**
 * https://developer.mozilla.org/en-US/docs/Web/Accessibility/ARIA/ARIA_Techniques
 * <p>
 * Using ARIA: Roles, states, and properties
 * <p>
 * ARIA defines semantics that can be applied to elements, with these divided into roles (defining a type of user interface element) and states and properties that are supported by a role. Authors must assign an ARIA role and the appropriate states and properties to an element during its life-cycle, unless the element already has appropriate ARIA semantics (via use of an appropriate HTML element). Addition of ARIA semantics only exposes extra information to a browser's accessibility API, and does not affect a page's DOM.
 */
public class AriaRoles {
    
    // Roles

    // Widget roles

    public static final String button = "button";
    public static final String checkbox = "checkbox";
    public static final String gridcell = "gridcell";
    public static final String link = "link";
    public static final String menuitem = "menuitem";
    public static final String menuitemcheckbox = "menuitemcheckbox";
    public static final String menuitemradio = "menuitemradio";
    public static final String option = "option";
    public static final String progressbar = "progressbar";
    public static final String radio = "radio";
    public static final String scrollbar = "scrollbar";
    public static final String searchbox = "searchbox";
    public static final String separator = "separator"; // (when focusable)
    public static final String slider = "slider";
    public static final String spinbutton = "spinbutton";
    public static final String switch_ = "switch";
    public static final String tab = "tab";
    public static final String tabpanel = "tabpanel";
    public static final String textbox = "textbox";
    public static final String treeitem = "treeitem";

    // Composite roles

    // The techniques below describe each composite role as well as their required and optional child roles.

    public static final String combobox = "combobox";
    public static final String grid = "grid"; // (including row, gridcell, rowheader, columnheader roles)
    public static final String listbox = "listbox"; // (including option role)
    public static final String menu = "menu";
    public static final String menubar = "menubar";
    public static final String radiogroup = "radiogroup"; // (see radio role)
    public static final String tablist = "tablist"; // (including tab and tabpanel roles)
    public static final String tree = "tree";
    public static final String treegrid = "treegrid";

    // Document structure roles

    public static final String application = "application";
    public static final String article = "article";
    public static final String cell = "cell";
    public static final String columnheader = "columnheader";
    public static final String definition = "definition";
    public static final String directory = "directory";
    public static final String document = "document";
    public static final String feed = "feed";
    public static final String figure = "figure";
    public static final String group = "group";
    public static final String heading = "heading";
    public static final String img = "img";
    public static final String list = "list";
    public static final String listitem = "listitem";
    public static final String math = "math";
    public static final String none = "none";
    public static final String note = "note";
    public static final String presentation = "presentation";
    public static final String row = "row";
    public static final String rowgroup = "rowgroup";
    public static final String rowheader = "rowheader";
    // duplicate: public static final String separator = "separator";
    public static final String table = "table";
    public static final String term = "term";
    public static final String toolbar = "toolbar";
    public static final String tooltip = "tooltip";

    // Landmark roles

    public static final String banner = "banner";
    public static final String complementary = "complementary";
    public static final String contentinfo = "contentinfo";
    public static final String form = "form";
    public static final String main = "main";
    public static final String navigation = "navigation";
    public static final String region = "region";
    public static final String search = "search";

    // Live Region Roles

    public static final String alert = "alert";
    public static final String log = "log";
    public static final String marquee = "marquee";
    public static final String status = "status";
    public static final String timer = "timer";

    // Window Roles

    public static final String alertdialog = "alertdialog";
    public static final String dialog = "dialog";

    // j2html Attributes

    public static final Attribute  roleButton = new Attribute("role","button");
    public static final Attribute  roleCheckbox = new Attribute("role","checkbox");
    public static final Attribute  roleGridcell = new Attribute("role","gridcell");
    public static final Attribute  roleLink = new Attribute("role","link");
    public static final Attribute  roleMenuitem = new Attribute("role","menuitem");
    public static final Attribute  roleMenuitemcheckbox = new Attribute("role","menuitemcheckbox");
    public static final Attribute  roleMenuitemradio = new Attribute("role","menuitemradio");
    public static final Attribute  roleOption = new Attribute("role","option");
    public static final Attribute  roleProgressbar = new Attribute("role","progressbar");
    public static final Attribute  roleRadio = new Attribute("role","radio");
    public static final Attribute  roleScrollbar = new Attribute("role","scrollbar");
    public static final Attribute  roleSearchbox = new Attribute("role","searchbox");
    public static final Attribute  roleSeparator = new Attribute("role","separator"); // (when focusable)
    public static final Attribute  roleSlider = new Attribute("role","slider");
    public static final Attribute  roleSpinbutton = new Attribute("role","spinbutton");
    public static final Attribute  roleSwitch = new Attribute("role","switch");
    public static final Attribute  roleTab = new Attribute("role","tab");
    public static final Attribute  roleTabpanel = new Attribute("role","tabpanel");
    public static final Attribute  roleTextbox = new Attribute("role","textbox");
    public static final Attribute  roleTreeitem = new Attribute("role","treeitem");

    // Composite roles

    // The techniques below describe each composite role as well as their required and optional child roles.

    public static final Attribute  roleCombobox = new Attribute("role","combobox");
    public static final Attribute  roleGrid = new Attribute("role","grid"); // (including row, gridcell, rowheader, columnheader roles)
    public static final Attribute  roleListbox = new Attribute("role","listbox"); // (including option role)
    public static final Attribute  roleMenu = new Attribute("role","menu");
    public static final Attribute  roleMenubar = new Attribute("role","menubar");
    public static final Attribute  roleRadiogroup = new Attribute("role","radiogroup"); // (see radio role)
    public static final Attribute  roleTablist = new Attribute("role","tablist"); // (including tab and tabpanel roles)
    public static final Attribute  roleTree = new Attribute("role","tree");
    public static final Attribute  roleTreegrid = new Attribute("role","treegrid");

    // Document structure roles

    public static final Attribute  roleApplication = new Attribute("role","application");
    public static final Attribute  roleArticle = new Attribute("role","article");
    public static final Attribute  roleCell = new Attribute("role","cell");
    public static final Attribute  roleColumnheader = new Attribute("role","columnheader");
    public static final Attribute  roleDefinition = new Attribute("role","definition");
    public static final Attribute  roleDirectory = new Attribute("role","directory");
    public static final Attribute  roleDocument = new Attribute("role","document");
    public static final Attribute  roleFeed = new Attribute("role","feed");
    public static final Attribute  roleFigure = new Attribute("role","figure");
    public static final Attribute  roleGroup = new Attribute("role","group");
    public static final Attribute  roleHeading = new Attribute("role","heading");
    public static final Attribute  roleImg = new Attribute("role","img");
    public static final Attribute  roleList = new Attribute("role","list");
    public static final Attribute  roleListitem = new Attribute("role","listitem");
    public static final Attribute  roleMath = new Attribute("role","math");
    public static final Attribute  roleNone = new Attribute("role","none");
    public static final Attribute  roleNote = new Attribute("role","note");
    public static final Attribute  rolePresentation = new Attribute("role","presentation");
    public static final Attribute  roleRow = new Attribute("role","row");
    public static final Attribute  roleRowgroup = new Attribute("role","rowgroup");
    public static final Attribute  roleRowheader = new Attribute("role","rowheader");
    // duplicate: public static final Attribute  roleseparator = new Attribute("role","separator");
    public static final Attribute  roleTable = new Attribute("role","table");
    public static final Attribute  roleTerm = new Attribute("role","term");
    public static final Attribute  roleToolbar = new Attribute("role","toolbar");
    public static final Attribute  roleTooltip = new Attribute("role","tooltip");

    // Landmark roles

    public static final Attribute  roleBanner = new Attribute("role","banner");
    public static final Attribute  roleComplementary = new Attribute("role","complementary");
    public static final Attribute  roleContentinfo = new Attribute("role","contentinfo");
    public static final Attribute  roleForm = new Attribute("role","form");
    public static final Attribute  roleMain = new Attribute("role","main");
    public static final Attribute  roleNavigation = new Attribute("role","navigation");
    public static final Attribute  roleRegion = new Attribute("role","region");
    public static final Attribute  roleSearch = new Attribute("role","search");

    // Live Region Roles

    public static final Attribute  roleAlert = new Attribute("role","alert");
    public static final Attribute  roleLog = new Attribute("role","log");
    public static final Attribute  roleMarquee = new Attribute("role","marquee");
    public static final Attribute  roleStatus = new Attribute("role","status");
    public static final Attribute  roleTimer = new Attribute("role","timer");

    // Window Roles

    public static final Attribute  roleAlertdialog = new Attribute("role","alertdialog");
    public static final Attribute  roleDialog = new Attribute("role","dialog");



}
