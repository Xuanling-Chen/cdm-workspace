package cdm.product.template;

import cdm.product.template.meta.OptionStyleMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The qualification of the option style: American, Bermuda or European. FpML implements those features as part of a substitution group.
 * @version ${project.version}
 */
@RosettaClass

public interface OptionStyle extends RosettaModelObject {
	OptionStyle build();
	OptionStyle.OptionStyleBuilder toBuilder();
	
	/**
	 */
	AmericanExercise getAmericanExercise();
	/**
	 */
	BermudaExercise getBermudaExercise();
	/**
	 */
	EuropeanExercise getEuropeanExercise();
	final static OptionStyleMeta metaData = new OptionStyleMeta();
	
	@Override
	default RosettaMetaData<? extends OptionStyle> metaData() {
		return metaData;
	} 
			
	static OptionStyle.OptionStyleBuilder builder() {
		return new OptionStyle.OptionStyleBuilderImpl();
	}
	
	default Class<? extends OptionStyle> getType() {
		return OptionStyle.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("americanExercise"), processor, AmericanExercise.class, getAmericanExercise());
		processRosetta(path.newSubPath("bermudaExercise"), processor, BermudaExercise.class, getBermudaExercise());
		processRosetta(path.newSubPath("europeanExercise"), processor, EuropeanExercise.class, getEuropeanExercise());
	}
	
	
	interface OptionStyleBuilder extends OptionStyle, RosettaModelObjectBuilder {
		AmericanExercise.AmericanExerciseBuilder getOrCreateAmericanExercise();
		AmericanExercise.AmericanExerciseBuilder getAmericanExercise();
		BermudaExercise.BermudaExerciseBuilder getOrCreateBermudaExercise();
		BermudaExercise.BermudaExerciseBuilder getBermudaExercise();
		EuropeanExercise.EuropeanExerciseBuilder getOrCreateEuropeanExercise();
		EuropeanExercise.EuropeanExerciseBuilder getEuropeanExercise();
		OptionStyle.OptionStyleBuilder setAmericanExercise(AmericanExercise americanExercise);
		OptionStyle.OptionStyleBuilder setBermudaExercise(BermudaExercise bermudaExercise);
		OptionStyle.OptionStyleBuilder setEuropeanExercise(EuropeanExercise europeanExercise);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("americanExercise"), processor, AmericanExercise.AmericanExerciseBuilder.class, getAmericanExercise());
			processRosetta(path.newSubPath("bermudaExercise"), processor, BermudaExercise.BermudaExerciseBuilder.class, getBermudaExercise());
			processRosetta(path.newSubPath("europeanExercise"), processor, EuropeanExercise.EuropeanExerciseBuilder.class, getEuropeanExercise());
		}
		
	}
	
	//OptionStyle.OptionStyleImpl
	class OptionStyleImpl implements OptionStyle {
		private final AmericanExercise americanExercise;
		private final BermudaExercise bermudaExercise;
		private final EuropeanExercise europeanExercise;
		
		protected OptionStyleImpl(OptionStyle.OptionStyleBuilder builder) {
			this.americanExercise = ofNullable(builder.getAmericanExercise()).map(f->f.build()).orElse(null);
			this.bermudaExercise = ofNullable(builder.getBermudaExercise()).map(f->f.build()).orElse(null);
			this.europeanExercise = ofNullable(builder.getEuropeanExercise()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public AmericanExercise getAmericanExercise() {
			return americanExercise;
		}
		
		@Override
		public BermudaExercise getBermudaExercise() {
			return bermudaExercise;
		}
		
		@Override
		public EuropeanExercise getEuropeanExercise() {
			return europeanExercise;
		}
		
		@Override
		public OptionStyle build() {
			return this;
		}
		
		@Override
		public OptionStyle.OptionStyleBuilder toBuilder() {
			OptionStyle.OptionStyleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionStyle.OptionStyleBuilder builder) {
			ofNullable(getAmericanExercise()).ifPresent(builder::setAmericanExercise);
			ofNullable(getBermudaExercise()).ifPresent(builder::setBermudaExercise);
			ofNullable(getEuropeanExercise()).ifPresent(builder::setEuropeanExercise);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionStyle _that = getType().cast(o);
		
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!Objects.equals(bermudaExercise, _that.getBermudaExercise())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (americanExercise != null ? americanExercise.hashCode() : 0);
			_result = 31 * _result + (bermudaExercise != null ? bermudaExercise.hashCode() : 0);
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionStyle {" +
				"americanExercise=" + this.americanExercise + ", " +
				"bermudaExercise=" + this.bermudaExercise + ", " +
				"europeanExercise=" + this.europeanExercise +
			'}';
		}
	}
	
	//OptionStyle.OptionStyleBuilderImpl
	class OptionStyleBuilderImpl implements OptionStyle.OptionStyleBuilder {
	
		protected AmericanExercise.AmericanExerciseBuilder americanExercise;
		protected BermudaExercise.BermudaExerciseBuilder bermudaExercise;
		protected EuropeanExercise.EuropeanExerciseBuilder europeanExercise;
	
		public OptionStyleBuilderImpl() {
		}
	
		@Override
		public AmericanExercise.AmericanExerciseBuilder getAmericanExercise() {
			return americanExercise;
		}
		
		@Override
		public AmericanExercise.AmericanExerciseBuilder getOrCreateAmericanExercise() {
			AmericanExercise.AmericanExerciseBuilder result;
			if (americanExercise!=null) {
				result = americanExercise;
			}
			else {
				result = americanExercise = AmericanExercise.builder();
			}
			
			return result;
		}
		
		@Override
		public BermudaExercise.BermudaExerciseBuilder getBermudaExercise() {
			return bermudaExercise;
		}
		
		@Override
		public BermudaExercise.BermudaExerciseBuilder getOrCreateBermudaExercise() {
			BermudaExercise.BermudaExerciseBuilder result;
			if (bermudaExercise!=null) {
				result = bermudaExercise;
			}
			else {
				result = bermudaExercise = BermudaExercise.builder();
			}
			
			return result;
		}
		
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder getEuropeanExercise() {
			return europeanExercise;
		}
		
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder getOrCreateEuropeanExercise() {
			EuropeanExercise.EuropeanExerciseBuilder result;
			if (europeanExercise!=null) {
				result = europeanExercise;
			}
			else {
				result = europeanExercise = EuropeanExercise.builder();
			}
			
			return result;
		}
		
	
		@Override
		public OptionStyle.OptionStyleBuilder setAmericanExercise(AmericanExercise americanExercise) {
			this.americanExercise = americanExercise==null?null:americanExercise.toBuilder();
			return this;
		}
		@Override
		public OptionStyle.OptionStyleBuilder setBermudaExercise(BermudaExercise bermudaExercise) {
			this.bermudaExercise = bermudaExercise==null?null:bermudaExercise.toBuilder();
			return this;
		}
		@Override
		public OptionStyle.OptionStyleBuilder setEuropeanExercise(EuropeanExercise europeanExercise) {
			this.europeanExercise = europeanExercise==null?null:europeanExercise.toBuilder();
			return this;
		}
		
		@Override
		public OptionStyle build() {
			return new OptionStyle.OptionStyleImpl(this);
		}
		
		@Override
		public OptionStyle.OptionStyleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionStyle.OptionStyleBuilder prune() {
			if (americanExercise!=null && !americanExercise.prune().hasData()) americanExercise = null;
			if (bermudaExercise!=null && !bermudaExercise.prune().hasData()) bermudaExercise = null;
			if (europeanExercise!=null && !europeanExercise.prune().hasData()) europeanExercise = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmericanExercise()!=null && getAmericanExercise().hasData()) return true;
			if (getBermudaExercise()!=null && getBermudaExercise().hasData()) return true;
			if (getEuropeanExercise()!=null && getEuropeanExercise().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionStyle.OptionStyleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionStyle.OptionStyleBuilder o = (OptionStyle.OptionStyleBuilder) other;
			
			merger.mergeRosetta(getAmericanExercise(), o.getAmericanExercise(), this::setAmericanExercise);
			merger.mergeRosetta(getBermudaExercise(), o.getBermudaExercise(), this::setBermudaExercise);
			merger.mergeRosetta(getEuropeanExercise(), o.getEuropeanExercise(), this::setEuropeanExercise);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionStyle _that = getType().cast(o);
		
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!Objects.equals(bermudaExercise, _that.getBermudaExercise())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (americanExercise != null ? americanExercise.hashCode() : 0);
			_result = 31 * _result + (bermudaExercise != null ? bermudaExercise.hashCode() : 0);
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionStyleBuilder {" +
				"americanExercise=" + this.americanExercise + ", " +
				"bermudaExercise=" + this.bermudaExercise + ", " +
				"europeanExercise=" + this.europeanExercise +
			'}';
		}
	}
}
