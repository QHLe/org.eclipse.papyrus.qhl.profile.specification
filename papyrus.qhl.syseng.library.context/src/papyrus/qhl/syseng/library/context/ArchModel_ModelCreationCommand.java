package papyrus.qhl.syseng.library.context;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.sysml14.util.SysMLResource;
import org.eclipse.papyrus.uml.diagram.common.commands.ModelCreationCommandBase;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;

import papyrus.qhl.syseng.library.profile.SysEngineering.ProfileResourceSpecification;

public class ArchModel_ModelCreationCommand extends ModelCreationCommandBase {

	/**
	 * @see org.eclipse.papyrus.infra.core.extension.commands.ModelCreationCommandBase#createRootElement()
	 *
	 * @return
	 */

	@Override
	protected EObject createRootElement() {
		return UMLFactory.eINSTANCE.createModel();
	}

	/**
	 * A standard Library model should have :
	 *  - the Library profile applied
	 *  
	 * @see org.eclipse.papyrus.infra.core.extension.commands.ModelCreationCommandBase#initializeModel(org.eclipse.emf.ecore.EObject)
	 *
	 * @param owner
	 */

	@Override
	protected void initializeModel(EObject owner) {
		super.initializeModel(owner);
		// Retrieve Library profile and apply it
		Package packageOwner = (Package) owner;
		Profile SysArchProfile = (Profile) PackageUtil.loadPackage(URI.createURI(ProfileResourceSysArch.PROFILE_PATH), owner.eResource().getResourceSet());
		if (SysArchProfile != null) {
			PackageUtil.applyProfile(packageOwner, SysArchProfile, true);
		}
		Profile SpecProfile = (Profile) PackageUtil.loadPackage(URI.createURI(ProfileResourceSpecification.PROFILE_PATH), owner.eResource().getResourceSet());
		if (SpecProfile != null) {
			PackageUtil.applyProfile(packageOwner, SpecProfile, true);
		}
		Profile SysMLProfile = (Profile) PackageUtil.loadPackage(URI.createURI(SysMLResource.PROFILE_PATH), owner.eResource().getResourceSet());
		if (SysMLProfile != null) {
			PackageUtil.applyProfile(packageOwner, SysMLProfile, true);
		}
	}
	
}
