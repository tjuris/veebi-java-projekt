Eclipse'i tõmbamine:
	-file->import->projects from git->uri
	-täita valitud väljad ning valida next kuni tuleb project wizard väli
	-valida import as general project
	-tekkinud projekti peal paremklikk, configure -> convert to faceted form
	-avanenud aknast valida dynamic web module ja JPA facetid
	-seejärel teha ant retrieve projekti build.xml failist
	-projekti lib/build/ kaustast leida javax.servlet-api... fail ning paremklikiga Build Path -> add to build path 
	-errorid peaksid kaduma ja asjad kenasti serveril käivituma
	
	
	lihtsalt testiks lisatud rida, et teada saada kas n��d l�puks asi t��tab