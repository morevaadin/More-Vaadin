/*
 * Copyright 2012 Nicolas Frankel
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.morevaadin.vaadin.externallayout;

import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;

@SuppressWarnings("serial")
public class EclipseMenuBar extends CustomComponent {

	private MenuBar bar = new MenuBar();

	public EclipseMenuBar() {

		setCompositionRoot(bar);

		createFileMenu();
		createEditMenu();
		createSearchProject();
		createProjectMenu();
		createWindowMenu();
		createHelpMenu();
	}

	private void createSearchProject() {

		MenuItem searchItem = bar.addItem("Search", null);

		searchItem.addItem("Search...", null);
		searchItem.addItem("File", null);
		searchItem.addItem("Java", null);
		searchItem.addItem("Remote", null);
		searchItem.addSeparator();

		String[] scopes = { "Workspace", "Project", "Hierarchy", "Working Set..." };
		String[] itemNames = { "Text", "References", "Declarations", "Implementors", "Read Access",
				"Write Access" };

		for (String itemName : itemNames) {

			MenuItem item = searchItem.addItem(itemName, null);

			for (String scope : scopes) {

				item.addItem(scope, null);
			}
		}

		searchItem.addSeparator();

		MenuItem occursItem = searchItem.addItem("Occurences in File", null);

		occursItem.addItem("Identifiers", null);
		occursItem.addItem("Implementing methods", null);
		occursItem.addItem("Throwing Exceptions", null);
		occursItem.addItem("Method Exists", null);
		occursItem.addItem("Break/Continue Targets", null);

		searchItem.addSeparator();
		searchItem.addItem("Referring Tests...", null);
	}

	private void createProjectMenu() {

		MenuItem projectItem = bar.addItem("Project", null);

		projectItem.addItem("Open Project", null);
		projectItem.addItem("Close Project", null);
		projectItem.addSeparator();
		projectItem.addItem("Build All", null);
		projectItem.addItem("Build Project", null);

		MenuItem workingSetItem = projectItem.addItem("Build Working Set", null);

		workingSetItem.addItem("Select Working Set...", null);

		projectItem.addItem("Clean...", null);

		MenuItem automaticItem = projectItem.addItem("Build Automatically", null);
		automaticItem.setCheckable(true);
		automaticItem.setChecked(true);

		projectItem.addSeparator();
		projectItem.addItem("Generate Javadoc", new ExternalResource("icons/javadoc.gif"), null);
		projectItem.addSeparator();
		projectItem.addItem("Properties", null);
	}

	private void createHelpMenu() {

		MenuItem helpItem = bar.addItem("Help", null);

		helpItem.addItem("Welcome", new ExternalResource("icons/welcome16.gif"), null);
		helpItem.addSeparator();
		helpItem.addItem("Help Contents", new ExternalResource("icons/help_contents.gif"), null);
		helpItem.addItem("Search", null);
		helpItem.addItem("Dynamic Help", null);
		helpItem.addSeparator();
		helpItem.addItem("Key Assist...", null);
		helpItem.addItem("Tips and Tricks...", null);
		helpItem.addItem("Report Bug Enhancement...", null);
		helpItem.addItem("Cheat Sheets...", null);
		helpItem.addSeparator();
		helpItem.addItem("Java EE 6 Documentation", null);
		helpItem.addItem("Java EE 5 Documentation", null);
		helpItem.addItem("Check for Updates", null);
		helpItem.addItem("Install New Software...", null);
		helpItem.addItem("Eclipse Updates...", null);
		helpItem.addSeparator();
		helpItem.addItem("About JRebel", null);
		helpItem.addItem("About Eclipse", null);
	}

	private void createWindowMenu() {

		MenuItem windowItem = bar.addItem("Window", null);

		windowItem.addItem("New Window", null);
		windowItem.addItem("New Editor", null);
		windowItem.addSeparator();

		MenuItem perspectiveItem = windowItem.addItem("Open Perspective", null);

		perspectiveItem.addItem("Debug", null);
		perspectiveItem.addItem("Java", null);
		perspectiveItem.addItem("JPA", null);
		perspectiveItem.addItem("Resources", null);
		perspectiveItem.addSeparator();
		perspectiveItem.addItem("Other...", null);

		windowItem.addSeparator();
		windowItem.addItem("Custom Perspective...", null);
		windowItem.addItem("Save Perspective As...", null);
		windowItem.addItem("Reset Perspective...", null);
		windowItem.addItem("Close Perspective", null);
		windowItem.addItem("Close All Perspectives", null);
		windowItem.addSeparator();
		windowItem.addItem("Navigation", null);
		windowItem.addSeparator();

		MenuItem browserItem = windowItem.addItem("Web Browser", null);

		browserItem.addItem("0 Internal Web Browser", null);
		browserItem.addItem("1 Default System Web Browser", null);
		browserItem.addItem("2 Firefox", null);
		browserItem.addItem("3 Internet Explorer", null);

		windowItem.addItem("Preferences", null);
	}

	private void createEditMenu() {

		MenuItem editItem = bar.addItem("Edit", null);

		editItem.addItem("Undo Typing", null);
		editItem.addItem("Redo", null);
		editItem.addSeparator();
		editItem.addItem("Cut", null);
		editItem.addItem("Copy", null);
		editItem.addItem("Copy Qualified Name", new ExternalResource("icons/copy_edit_co.gif"), null);
		editItem.addItem("Paste", new ExternalResource("icons/paste_edit.gif"), null);
		editItem.addSeparator();
		editItem.addItem("Delete", new ExternalResource("icons/delete_obj.gif"), null);
		editItem.addItem("Select All", null);

		MenuItem expandItem = editItem.addItem("Expand Selection To", null);

		expandItem.addItem("Enclosing Element", null);
		expandItem.addItem("Next Element", null);
		expandItem.addItem("Previous Element", null);
		expandItem.addItem("Restore Last Selection", null);

		editItem.addSeparator();
		editItem.addItem("Find/Replace...", null);
		editItem.addItem("Find Next", null);
		editItem.addItem("Find Previous", null);
		editItem.addItem("Incremental Find Next", null);
		editItem.addItem("Incremental Find Previous", null);
		editItem.addSeparator();
		editItem.addItem("Add Bookmark...", null);
		editItem.addItem("Add Task...", null);
		editItem.addSeparator();

		MenuItem smartItem = editItem.addItem("Smart Insert Mode", null);
		smartItem.setCheckable(true);
		smartItem.setChecked(true);

		editItem.addSeparator();
		editItem.addItem("Show Tooltip Description", null);
		editItem.addSeparator();

		MenuItem contentItem = editItem.addItem("Content Assist", null);

		contentItem.addItem("Default", null);
		contentItem.addItem("Groovy Content", null);
		contentItem.addItem("Java Type Proposals", null);
		contentItem.addItem("Java Non-Type Proposals", null);
		contentItem.addItem("Java Proposals", null);

		editItem.addItem("Word Completion", null);
		editItem.addItem("Quick Fix", null);
		editItem.addSeparator();
		editItem.addItem("Set Encoding...", null);
	}

	private void createFileMenu() {

		MenuItem fileItem = bar.addItem("File", null);

		fileItem.addItem("New", null);
		fileItem.addItem("Open File...", null);
		fileItem.addSeparator();
		fileItem.addItem("Close", null);
		fileItem.addItem("Close All", null);
		fileItem.addSeparator();
		fileItem.addItem("Save", null);
		fileItem.addItem("Save As...", new ExternalResource("icons/saveas_edit.gif"), null);
		fileItem.addItem("Save All", null);
		fileItem.addItem("Revert", null);
		fileItem.addSeparator();
		fileItem.addItem("Move...", null);
		fileItem.addItem("Rename...", null);
		fileItem.addItem("Refresh", new ExternalResource("icons/refresh_nav.gif"), null);

		MenuItem convertItem = fileItem.addItem("Convert Delimiters To", null);

		convertItem.addItem("Windows", null);
		convertItem.addItem("Unix", null);
		convertItem.addItem("MacOS 9", null);

		fileItem.addSeparator();
		fileItem.addItem("Print...", new ExternalResource("icons/nav_print.gif"), null);
		fileItem.addSeparator();
		fileItem.addItem("Switch Workspace", null);
		fileItem.addItem("Restart", null);
		fileItem.addSeparator();
		fileItem.addItem("Import...", new ExternalResource("icons/import_wiz.gif"), null);
		fileItem.addItem("Export...", new ExternalResource("icons/export_wiz.gif"), null);
		fileItem.addSeparator();
		fileItem.addItem("Properties", null);
		fileItem.addSeparator();
		fileItem.addItem("Exit", null);
	}
}
