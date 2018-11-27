package de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces;

import de.hterhors.obie.core.ontology.AbstractIndividual;
import de.hterhors.obie.core.ontology.IndividualFactory;
import de.hterhors.obie.core.ontology.annotations.AssignableSubClasses;
import de.hterhors.obie.core.ontology.annotations.AssignableSubInterfaces;
import de.hterhors.obie.core.ontology.annotations.DatatypeProperty;
import de.hterhors.obie.core.ontology.annotations.DirectInterface;
import de.hterhors.obie.core.ontology.annotations.DirectSiblings;
import de.hterhors.obie.core.ontology.annotations.ImplementationClass;
import de.hterhors.obie.core.ontology.annotations.OntologyModelContent;
import de.hterhors.obie.core.ontology.annotations.RelationTypeCollection;
import de.hterhors.obie.core.ontology.annotations.SuperRootClasses;
import de.hterhors.obie.core.ontology.annotations.TextMention;
import de.uni.bielefeld.sc.hterhors.psink.obie.projects.scio.ontology.interfaces.*;
import org.apache.jena.rdf.model.Model;
/**
*
* @author hterhors
*
*
*Oct 23, 2018
*/

@AssignableSubInterfaces(get={IGroomingObservation.class, ISpinalDorsalHalf.class, ISpinalWhiteMatter.class, IBodyWeightExamination.class, IRehabilitativeTraining.class, IDogSpecies.class, IDarbepoetin.class, IMotorTest.class, IPsychologicalState.class, IMacrophageCell.class, ILouisvilleSwimScale.class, IAspirationLesion.class, IMelatonin.class, IOrganismSpecies.class, IPhysicalTreatment.class, IObservationOfAnimalBehaviour.class, IMinipigModel.class, IMesenchymalStemCell.class, ILipopolysaccharide.class, ITetracycline.class, IStandardError.class, IDNA.class, IIsoflurane.class, IRetrovirus.class, INonNeuronalCellChangesTest.class, IRabbitSpecies.class, IRecombinantEPORhEpo.class, IAgeCategory.class, ISaline.class, IInclinedPlaneTest.class, ISpasticityObservation.class, IMedicationDuringSurgery.class, IInvestigationMethod.class, INeuronalChangesTest.class, ILethargyObservation.class, IP188.class, ICompoundBiologicalRelation.class, IBrain.class, IDMSO.class, IPregabalin.class, IElectricFieldStrength.class, IAngiogenesisTest.class, IMotorReflexTest.class, ISchwannCell.class, IDuration.class, ILocomotorFunction.class, IDosage.class, IBoneMarrowStemCell.class, IVehicle.class, ISurvivalObservation.class, ITissue.class, IAxonalDamageTest.class, IPhenytoine.class, IDehydroEpiandrosteroneSulfate.class, IAnalyzedExperimentalGroup.class, IObservation.class, IHalothane.class, ISpinalLesionSite.class, IForce.class, IVertebrae.class, IVertebralSegment.class, IPositiveSignificance.class, IProteinLevelAnalysis.class, IMexiletine.class, IUmbilicalCordBloodStemCell.class, IUnivOfTriesteImpactor.class, IDeliveryMethod.class, IGroupName.class, IInjuryArea.class, IElectrophysiologyTest.class, IHemorrhageTest.class, ITreadmillTraining.class, ISurgeryTreatment.class, IToxicityTest.class, ICompoundTreatment.class, ISomatosensoryEvokedPotentialsTest.class, ISensoryTest.class, IMonkeySpecies.class, IPhysicalImplantTreatment.class, IAnimalModel.class, IFunctionalTest.class, IJudgement.class, IRNA.class, ILadderRungTest.class, IElectromagneticFieldTreatment.class, ISC58125.class, IBodyTemperatureMeasurement.class, IAlbumin.class, ISubstance.class, ILateralHemisection.class, ICompleteTransection.class, IInhalationDelivery.class, IGeneExpressionAnalysis.class, IOralDelivery.class, IBloodBrainBarrierTest.class, IAxonalDiebackTest.class, IAtorvastatinAT.class, IGender.class, I_17BetaEstradiolE2.class, INS398.class, IOligodendrogliaChangesTest.class, INeurogenesisTest.class, IPEGFITC.class, IPhotochemicalInjury.class, ICompoundSupplier.class, IApplicationInstrument.class, ISelfMutilationObservation.class, IAxonalRegenerationTest.class, IDosageIntracorporal.class, IVoltageApplication.class, IMinocyclineMC.class, IBlade.class, IPolyethyleneGlycolPEG.class, IOlfactoryEnsheathingGliaCell.class, IPatient.class, IGuineaPigSpecies.class, IPhysiologyTest.class, IDistractorDevices.class, IVirus.class, IHistologicalInvestgationTest.class, IKetamine.class, ICatModel.class, IApparatus.class, ITemperature.class, IOxidativeStressTest.class, IInjury.class, IInjuryIntensity.class, IApoptosisTest.class, IAsialoEPO.class, IMouseSpecies.class, IMASCISImpactor.class, IExtremity.class, IGlycopyrrolate.class, ILightIntensity.class, IImmuneCell.class, IVentralHemisection.class, IFluanisoneMidazolamMixture.class, IDorsalColumn.class, ICurrent.class, IRearingTest.class, ICell.class, IPainTest.class, IInterval.class, IHematoxyLinEosin.class, IThickness.class, IAnimalCareCondition.class, INitrousOxide.class, ISpatialDimensions.class, IAxonalSproutingTest.class, ISpinalSubduralArea.class, IMicrodialysisDelivery.class, ILength.class, INumericValue.class, IInjectionDelivery.class, IMagnesium.class, IBalloon.class, IRostral.class, ISwimmingTest.class, IInfectionExamination.class, IHReflexTest.class, ISpinalFiberTract.class, IAnatomicalLocation.class, INonFunctionalTest.class, IBloodCirculationExamination.class, IBBBTest.class, IMouseModel.class, IScarringTest.class, IEpiduralClip.class, IFogartyBalloonCatheter.class, ICentralNervousSystem.class, IEvansBlue.class, INNumber.class, ISensoryFunction.class, INormothermicTreatment.class, IStemCellSourceType.class, ILesionAdjacentTissue.class, IStaircaseTest.class, IInvestigation.class, IStandardDeviation.class, IAntibody.class, ILentivirus.class, IPregnenolone.class, ILocomotorTest.class, IDogModel.class, IMotorEvokedPotentialsTest.class, ICardioVascularFunctionTest.class, IOrganismModel.class, IForelimbStrengthTest.class, IHypothermicTreatment.class, ITemperatureTreatment.class, IBBBSubscoreTest.class, IOvariectomyTreatment.class, IDefinedExperimentalGroup.class, IProgesterone.class, IInosine.class, IAxonalChangesTest.class, IStatisticalTest.class, IRight.class, IMolecularChangesTest.class, IMethanesulfonamide.class, IErythropoietin.class, IHeatLesion.class, IAnaesthetic.class, ISteroid.class, IQudt_Quantity.class, IAntiCD11dAntibody.class, IEpidural.class, IAneurysmClip.class, IDosageExtracorporal.class, IArylsulfataseB.class, INonNumericValue.class, IStudyDesign.class, IPioglitazone.class, IRatModel.class, ITyrosineHydroxylase.class, IDirection.class, ICuttingDevice.class, IBW755C.class, IEthanol.class, IThermalHyperalgesiaTest.class, ICatSpecies.class, IIntraspinal.class, IGaleRatingScoreTest.class, ISpinalCentralPart.class, IXylazine.class, IName.class, IUrineVoidingTest.class, IAlphaSignificanceNiveau.class, IPostsurgicalMedication.class, IExperimentalMethod.class, ISecondaryDegenerationTest.class, IElectrolyticLesion.class, IConduit.class, IMotorFunction.class, IGuineaPigModel.class, IVolume.class, IInjuryDevice.class, IAutomatedGaitAnalysis.class, IMinipigSpecies.class, ISuperficialDelivery.class, IElectrodes.class, IEnrichedEnvironment.class, ISpinalCord.class, IAnimalSpecies.class, ISedative.class, IRubrospinalTract.class, INT3Lentivirus.class, IEstrogen.class, IManualDexterityTest.class, ISpinalVentralHalf.class, IKeepingCondition.class, IResult.class, IVegetableOil.class, IDislocation.class, IIloprost.class, IZeroSignificance.class, ICompound.class, IOpenFieldTest.class, ITreatment.class, INYUImpactor.class, IRatSpecies.class, IChondroitinaseABC.class, IInfusionDelivery.class, INOGOReceptorAntagonist.class, IHormone.class, ISpinalCordEvokedPotentialsTest.class, IMagnesiumSulfate.class, IAdhesiveRemovalTest.class, IExperimentalGroup.class, IGaitTest.class, IVoltage.class, ITailFlickReflexTest.class, IBrainDerivedNeurotrophicFactor.class, IAntiNG2Antibody.class, ISchwannCellChangesTest.class, IRabbitModel.class, INucleicAcid.class, ITissueSparingTest.class, IKetamineAsAnaesthetic.class, IPressure.class, IAtropineSulfate.class, IFunction.class, IPublication.class, INarrowBeamTest.class, IInflammationTest.class, INeuroprotectionTest.class, INeuronalCellLossTest.class, IPubmedID.class, ISignificance.class, IProtein.class, IAutonomicDysreflexiaTest.class, IVertebralArea.class, IInfiniteHorizonImpactor.class, IMechanicalAllodyniaTest.class, INeuronalActivityTest.class, IAscendingFiberTract.class, ISodiumPentobarbital.class, IWalkingAnalysisTest.class, IPerson.class, IPartialTransection.class, IAntibioticMedication.class, IIndomethacin.class, IAstrogliosisTest.class, IClip.class, IBMSTest.class, IMedianValue.class, IMPSS.class, IMortalityObservation.class, IFrequency.class, ILaminectomy.class, ICurrentApplication.class, IRolipram.class, IPostSurgeryCondition.class, ICompression.class, ITotalPopulationSize.class, IAvoidanceResponseTest.class, IDipyridamol.class, IHindpawSensationTest.class, IPregnenoloneS.class, IEvent.class, IEnzyme.class, IGroupNumber.class, ICelebocid.class, ISurfaceRightingReflexTest.class, INeurotrophin3.class, ITime_TemporalEntity.class, IExperimentalProcedure.class, IRingersSolution.class, IAcetylsalicylicAcid.class, IHospitalization.class, IInjuryByAccident.class, IImpairmentProgression.class, IMeanValue.class, IIntrathecal.class, IStemCell.class, IEstradiolBenzoate.class, IObservedDifference.class, IAllenWeightDropDevice.class, ICystVolumeTest.class, IAntiNogoAAntibody.class, IContusion.class, IClodronate.class, IDorsalHemisection.class, IOSUImpactor.class, ILithiumChloride.class, ITemporalInterval.class, IMethylprednisoloneMP.class, IICI182780.class, IDepth.class, ICaudal.class, IMyelinationTest.class, IVertebralLocation.class, ICorticospinalTract.class, IIrisClip.class, ISpinalGrayMatter.class, IIbuprofen.class, IWeightDrop.class, IPBS.class, IMonkeyModel.class, IPValue.class, ILimbMuscleStrengthTest.class, IImagingTest.class, IConstraint.class, IPenicillinase.class, IVimentinAntiSenseDNA.class, ICompoundSource.class, IForceps.class, ITrend.class, ILocation.class, IDistraction.class, IMagneticFieldApplication.class, INeurologicScalesTest.class, IChloralHydrate.class, ILesionVolumeTest.class, IInVitroExperimentalProcedure.class, IScissors.class, IFootprintAnalysisTest.class, ISinglePelletReachingTest.class, IWater.class, IModificationTreatment.class, IGeneticModificationTreatment.class, IPoloxamer.class, IDiazepam.class, IRiluzole.class, IDistance.class, IValue.class, IExperiment.class, IAge.class, ICyclosporineA.class, ILeft.class, IPublicationYear.class, IRepeatedMeasureTrend.class, IThiopentalSodium.class, IContactPlacingResponseTest.class, IGastricUlcerogenesisTest.class, IP4.class, IForelimbAsymmetryTest.class, ISingleMeasureTrend.class, IMatrix.class, IInjuryByAccidentType.class, IGlialCell.class, ISubstanceApplicationLocation.class, IChemicalInjury.class, IWeight.class, })
 public interface ISCIOThing
 extends de.hterhors.obie.core.ontology.interfaces.IOBIEThing{

 public static String RDF_MODEL_NAMESPACE = "http://scio/data/";

/***/
	public Integer getCharacterOffset();


/***/
	public Integer getCharacterOnset();


/***/
	public String getONTOLOGY_NAME();


/***/
	public Model getRDFModel(String resourceIDPrefix);


/***/
	public String getResourceName();


/***/
	public String getTextMention();


/***/
	public boolean isEmpty();


/***/
	public void setCharacterOnset(Integer onset);


}
